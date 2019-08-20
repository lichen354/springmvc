package sram.springmvc.lesson03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * springmvc参数绑定
 * @author liche
 *
 */
@Controller
@RequestMapping("binding")
public class BindingController {
	
	/**
	 * 使用@RequestParam绑定请求体中参数
	 */
	@RequestMapping(value="/handle1")
	public String handle1(@RequestParam("userName") String userName,
			      @RequestParam("password") String password,
			      @RequestParam("realName") String realName){
		System.out.println("userName="+userName);
		System.out.println("password="+password);
		System.out.println("realName="+realName);
		return "index";
	}
	
	/**
	 * 使用@CookieValue绑定cookie中的参数
	 * 使用@RequestHeader绑定请求头中的参数
	 */
	@RequestMapping(value="/handle2")
	public String handle2(@CookieValue("JSESSIONID") String sessionId,
	       @RequestHeader("Accept-Language") String accpetLanguage){
		return "index";
	}
	
	/**
	 * 对象绑定
	 * Spring MVC按
	 * http参数名/表单属性名---对象属性名	的规则，自动绑定请求数据，自动进行基本类型数据转换
	 */
	@RequestMapping("handle3")
	public String handle3(User user) {
		System.out.println(user);
		return "index";
	}
}
