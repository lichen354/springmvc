package sram.springmvc.lesson04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在Spring MVC中，控制器类可以不依赖任何Servlet API对象，
 * 我们可以使用Servlet API的类作为处理方法的入参
 * @author liche
 */
@Controller
@RequestMapping("ServletController")
public class ServletController {
	
	/*
	 * 使用HttpServletRequest 作为入参
	 */
	@RequestMapping("handle1")
	public String handle1(HttpServletRequest req) {
		String name = req.getParameter("name");
		System.out.println(name);
		return "index";
	}
	
	/*
	 * 如果处理方法自行使用HttpServletResponse返回响应，则处理方法的返回值设置成void即可。
	 */
	@RequestMapping("handle2")
	public void handle2(HttpServletResponse res) {
		
		
	}
}
