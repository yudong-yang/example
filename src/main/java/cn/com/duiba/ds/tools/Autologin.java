package cn.com.duiba.ds.tools;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import main.CreditTool;

@Controller
public class Autologin {
	public static void main(String[] args) throws UnsupportedEncodingException {
		CreditTool tool = new CreditTool("3gyWdRiPKkaMiiH6V3RUFybsdeDZ", "4DEz67Z1VmzWVxUy5mVUnZoS2d8v"); // 正式环境应用

		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", "not_login");
		params.put("credits", "0");
		params.put("timestamp", "1572500807637");
		String redirect = "";
		if (redirect != null && redirect != "" && redirect != "null") {
			System.out.println(redirect);
			params.put("redirect", redirect);
		}
		String url = tool.buildUrlWithSign("http://www.duiba.com.cn/autoLogin/autologin?", params);
		System.out.println(url);
	}

}
