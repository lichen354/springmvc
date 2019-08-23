package sram.springmvc.lesson05;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
/**
 * 使用fast做Json处理
 * 注意:使用postman/aPizza发送请求
 * 需要配置fastjsonConverter
 */
@Controller
@RequestMapping("fastJsonConverterController")
public class FastJsonConverterController {
	/*
	 * 接收json转为map
	 */
	@RequestMapping("handle1")
	public String handle1(@RequestBody Map<String, Object> param) {
		System.out.println(param);
		return "index";
	}
	/*
	 * 接收json转换为JSONObject对象 fastjson
	 */
	@RequestMapping("handle2")
	public String handle2(@RequestBody JSONObject param) {
		System.out.println("JSONObject" + param);
		
		return "index";
	}
	
	/*
	 * 返回json字符串
	 */
	@RequestMapping("handle3")
	@ResponseBody
	public JSONObject handle3() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "张三");
		jsonObj.put("age", 12);
		
		return jsonObj;
	}
	
	/******************依然存在这样的写法 - - *****************/
	/*
	 * 接收json
	 */
	@RequestMapping("handle4")
	public String handle4(@RequestBody String jsonString) {
		JSONObject jsonObj = JSONObject.parseObject(jsonString);
		System.out.println(jsonObj);
		return "index";
	}
	
	/*
	 * 发送json串
	 */
	@RequestMapping("handle5")
	@ResponseBody
	public String handle5() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "李四");
		return jsonObj.toJSONString();
	}
}
