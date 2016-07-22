package cn.com.duiba.weixin.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import main.CreditConsumeResult;
import main.CreditNotifyParams;
import main.CreditTool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/duiba")
public class DuibaApi {
	@Value("${duiba.appKey}")
	private String appKey;

	@Value("${duiba.appSecret}")
	private String appSecret;

	@RequestMapping("/consume")
	@ResponseBody
	public String consume(HttpServletRequest request) {
		String paramsAppKey = request.getParameter("appKey"); // 获取code
		String orderNum = request.getParameter("orderNum"); // 获取兑吧订单号
		String bizId = "dbmarket-" + orderNum;
		Long credits = 0L;
		String errorMessage = "";
		boolean success = false;

		if (!appKey.equals(paramsAppKey)) {
			errorMessage = "服务器异常，appKey不匹配";
		} else if (orderNum == null) {
			errorMessage = "服务器异常，订单号为空";
		} else {
			success = true;
		}

		CreditConsumeResult ccr = new CreditConsumeResult(success);
		ccr.setErrorMessage(errorMessage);
		ccr.setBizId(bizId);
		ccr.setCredits(credits);
		return ccr.toString();
	}

	@RequestMapping("/notify")
	@ResponseBody
	public String notify(HttpServletRequest request) {
		CreditTool tool=new CreditTool("appKey", "appSecret");
		try {
		    CreditNotifyParams params= tool.parseCreditNotify(request);//利用tool来解析这个请求
		    String orderNum=params.getOrderNum();
		    if(params.isSuccess()){
		    	return "ok";
		    }else{
		    	//此处返还积分
		    	return "ok";
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    return "ok";
		}
		
	}

	@RequestMapping("/autologin")
	public RedirectView autologin(@RequestParam("uid") String uid, @RequestParam("dbredirect") String dbredirect)
			throws ParseException, IOException {
		{
			CreditTool tool = new CreditTool(appKey, appSecret);
			Map<String, String> params = new HashMap<String, String>();
			if (uid != null && uid != "" && uid != "null") {
				params.put("uid", uid);
			} else {
				params.put("uid", "not_login");
			}
			params.put("uid", uid);
			params.put("credits", "0");
			params.put("timestamp", "1572500807637");

			if (dbredirect != null && dbredirect != "" && dbredirect != "null") {
				params.put("redirect", dbredirect);
			}
			String url = tool.buildUrlWithSign("http://www.duiba.com.cn/autoLogin/autologin?", params);
			System.out.println(url);
			return new RedirectView(url, true, false, true);
		}
	}
}
