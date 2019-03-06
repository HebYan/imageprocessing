/**
 * 
 */
package com.zjnu.util;



import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author herbertyang
 *
 */
public class DealUtuil {

	
	/**
	 * 菜品识别 
	 * @param client  密钥
	 * @param urlStr   待识别对象URL
	 */
	public static void dishes(AipImageClassify client, String urlStr) {
		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("top_num", "3");
		options.put("filter_threshold", "0.7");
		options.put("baike_num", "5");

		// 参数为本地路径
		String image = urlStr;
		JSONObject res = client.dishDetect(image, options);
		System.out.println(res.toString(2));

	}
	
	/**
	 * 动物识别API
	 * @param client
	 */
	public static void animal(AipImageClassify client,String urlStr) {
		
		    HashMap<String, String> options = new HashMap<String, String>();
		    options.put("top_num", "3");
		    options.put("baike_num", "5");
		    
		    
		    // 参数为本地路径
		    String image = urlStr;
		    JSONObject res = client.animalDetect(image, options);
		    System.out.println(res.toString(2));

	    
	}

	public static void car(AipImageClassify client,String urlStr) {
		// TODO 自动生成的方法存根
		HashMap<String, String> options = new HashMap<String, String>();
	    options.put("top_num", "3");
	    options.put("baike_num", "5");
	    
	    
	    // 参数为本地路径
	    String image = urlStr;
	    JSONObject res = client.carDetect(image, options);
	    System.out.println(res.toString(2));
		
	}

	public static void plant(AipImageClassify client, String urlStr) {
		// TODO 自动生成的方法存根
		 // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("baike_num", "5");
	    
	    
	    // 参数为本地路径
	    String image = urlStr;
	    JSONObject res = client.plantDetect(image, options);
	    System.out.println(res.toString(2));

		
	}

	public static void trade(AipImageClassify client, String urlStr) {
		// TODO 自动生成的方法存根
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    
	    
	    // 参数为本地路径
	    String image = urlStr;
	    JSONObject res = client.logoDeleteByImage(image, options);
	    System.out.println(res.toString(2));

		
	}

	
	
}
