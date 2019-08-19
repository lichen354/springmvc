package sram.springmvc.lesson01.helloword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 第一个springmvc程序 helloWord
 * @author liche
 *
 */
@Controller
@RequestMapping("hello")
public class HelloWordController {

	@RequestMapping("helloword")
	public String index() {
		return "helloword";
	}
}
