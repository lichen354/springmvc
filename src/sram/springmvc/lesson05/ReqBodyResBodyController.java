package sram.springmvc.lesson05;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * httpMsgConverter:	http中的参数<->对象
 * 	@requestBody 接收请求体
 * 	@ResponseBody 接收响应体
 * @author liche
 *
 */
@Controller
@RequestMapping("requestBodyResponseBody")
public class ReqBodyResBodyController {
	
	/*
	 * 将请求参数转换为String
	 */
	@RequestMapping("handle1")
	public String handle1(@RequestBody String param) {
		System.out.println(param);
		return "index";
	}
	
	/*
	 * 返回字符串
	 */
	@RequestMapping("handle2")
	@ResponseBody
	public String handle2() {
		
		return "i love China";
	}
}
