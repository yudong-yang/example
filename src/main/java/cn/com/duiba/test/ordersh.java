package cn.com.duiba.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import main.CreditTool;

public class ordersh {
	public static void main(String[] args) {
		
	/*	CreditTool tool=new CreditTool("3gyWdRiPKkaMiiH6V3RUFybsdeDZ", "4DEz67Z1VmzWVxUy5mVUnZoS2d8v");

		String url=tool.buildCreditOrderStatusRequest("2016081814261258000542629C0821","bzid-1732548757");
		System.out.println(url);*/
		
		
		
			String json = "[{\"id\":1,\"type\":\"cycle\",\"attribute\":{\"center\":\"(10.4, 123.345)\", \"radius\":67.4}},{\"id\":2,\"type\":\"polygon\",\"attribute\":[{\"vertex\":\"(10.4, 133.345)\"}, {\"vertex\":\"(10.4, 143.345)\"}]}]";
			
			JSONArray array = JSON.parseArray(json);
			
			System.out.println(array.getJSONObject(0).getJSONObject("attribute").get("radius"));
			
			System.out.println(array.getJSONObject(1).getJSONArray("attribute").getJSONObject(1).get("vertex"));
		
	}

}
