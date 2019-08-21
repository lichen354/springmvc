package sram.springmvc.lesson04;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

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
	public void handle2(HttpServletResponse res) throws IOException {
		res.getWriter().append("i love China");
		
	}
	/*
	 * springmvc提供的HttpServletRequest代理类
	 */
	@RequestMapping("handle3")
	public String handle3(WebRequest req) throws IOException {
		String name = req.getParameter("name");
		System.out.println(name);
		return "index";
	}
	
	/*
	 * 使用IO对象作为入参
	 * SpringMVC将获取ServletRequest的InputStream/Reader或ServletResponse的OutputStream/Writer,
	 * 然后按类型匹配的方式，传递给控制器的处理方法入参。
	 */
	@RequestMapping("handle4")
	public void handle4(OutputStream ops) throws IOException {
	       Resource resource = new ClassPathResource("sram/springmvc/lesson04/image.jpg");//读取类路径下的图片文件
	       FileCopyUtils.copy(resource.getInputStream(), ops);//将图片写到输出流中
	}
	/*
	 *从response中获取OutputStream对象
	 */
	@RequestMapping("handle5")
	public void handle5(HttpServletResponse res) throws IOException {
		//从response中获取OutputStream对象
		OutputStream ops = res.getOutputStream();
		
		Resource resource = new ClassPathResource("sram/springmvc/lesson04/image.jpg");//读取类路径下的图片文件
	    FileCopyUtils.copy(resource.getInputStream(), ops);//将图片写到输出流中
	}
	
	@RequestMapping("handle6")
	public String handle6(Locale locale) throws IOException {
		System.out.println(locale);
		return "index";
	}
	
}
