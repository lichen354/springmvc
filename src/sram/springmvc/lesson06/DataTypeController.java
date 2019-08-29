package sram.springmvc.lesson06;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import sram.springmvc.lesson06.editor.DateEditor;
import sram.springmvc.lesson06.pojo.Person;

/**
 * sprinmvc数据类型转换
 * @author liche
 * PropertyEditor资料来自 	https://my.oschina.net/sugarZone/blog/705169
 */
@Controller
@RequestMapping("dataType")
public class DataTypeController {
	
	/* 
	 * 提供默认的数据类型转换
	 * String -> Integer
	 */
	@RequestMapping("handle1")
	public String handle1(Integer num) {
		System.out.println("num="+num);
		return "index";
	}
	/*********************Date类型转换 需要设置PropertyEditor*********************************/
	//使用@InitBinder注解，在WebDataBinder对象上注册转换器。
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
	
	@RequestMapping("handle2")
	public String handle21(Date birth) {
		System.out.println("birth="+birth);
		return "index";
	}
	/*****上述介绍的方法其实都已过时-_-。在spring3.x后，新出了一个更强大的转换器机制，Converter!***/
	/*
	 * http://localhost:8080/springmvc/dataType/handle3?person=zhansan-12-nan
	 * 自定义Converter 格式化字符串"name-age-sex" -> Person对象
	 */
	@RequestMapping("handle3")
	public String handle21(Person person) {
		System.out.println("person="+person);
		return "index";
	}
	/*
	 * 假如PropertyEditor和Converter同时使用会怎么样呢？
	 * Spring的策略是先查找PropertyEditor进行类型转换，如果没有找到相应的PropertyEditor再通过Converter进行转换。
	 */
}
