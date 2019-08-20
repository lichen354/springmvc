package sram.springmvc.lesson02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HTTP请求地址映射
 * URL表达式 匹配
 * 支持Ant风格(即?、*和**的字符，的和带{xxx}占位符的URL)
 * @author liche
 */
@Controller
@RequestMapping("urlController")
public class URLController {

	//user/*/createUser
	//匹配/user/aaa/createUser、/user/bbb/createUser等URL。
	@RequestMapping("user/*/createUser")
	public String handle0() {
		System.out.println("handle0");
		return "index";
	}
	
	//user/**/createUser
    //匹配/user/createUser、/user/aaa/bbb/createUser等URL。
	@RequestMapping("user/**/createUser")
	public String handle1() {
		System.out.println("handle1");
		return "index";
	}
	
	//user/createUser??
	//匹配/user/createUseraa、/user/createUserbb等URL。
	@RequestMapping("user/createUser??")
	public String handle2() {
		System.out.println("handle2");
		return "index";
	}
	
	//user/{userId}
    //匹配user/123、user/abc等URL。
	@RequestMapping("user/{userId}")
	public String handle3() {
		System.out.println("handle3");
		return "index";
	}
	
	//user/**/{userId}
	//匹配user/aaa/bbb/123、user/aaa/456等URL。
	@RequestMapping("user/**/{userId}")
	public String handle4() {
		System.out.println("handle4");
		return "index";
	}
	
	//company/{companyId}/user/{userId}/detail
	//匹配company/123/user/456/detail等的URL。
	@RequestMapping("company/{companyId}/user/{userId}/detail")
	public String handle5() {
		System.out.println("handle5");
		return "index";
	}
	
}
