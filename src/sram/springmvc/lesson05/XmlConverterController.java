package sram.springmvc.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sram.springmvc.lesson05.pojo.Person;

/**
 * XML格式数据处理
 * 使用springmvc自带的jaxb2进行处理
 * 
 * JAXB(Java Architecture for XML Binding)是一个业界的标准,是一项可以根据XML Schema产生Java类的技术。
 * 该过程中，JAXB也提供了将XML实例文档反向生成Java对象树的方法，并能将Java对象树的内容重新写到 XML实例文档。
 * Jaxb 2.0是JDK 1.6的组成部分。我们不需要下载第三方jar包 即可做到轻松转换。
 * @author liche
 */
@Controller
@RequestMapping("xmlConverter")
public class XmlConverterController {
	
	/*
	 * 接收xml参数 并转换为java对象
	 */
	@RequestMapping(value="handle1")
    public String handle1(@RequestBody Person Person) {
		 System.out.println(Person);
		 return "index";
    } 
}
