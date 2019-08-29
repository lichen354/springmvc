package sram.springmvc.lesson06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sram.springmvc.lesson06.pojo.Emplyee;

/**
 * springmvc数据格式化
 * <mvc:annotation-driven/>标签自动支持如下的格式化注解：
 * @NumberFormat:用于数字类型对象的格式化
 * @DateTimeFormat: 用于日期类型对象的格式化
 *
 */
@Controller
@RequestMapping("format")
public class FormatController {
	/*
	 * 日期格式化
	 */
	@RequestMapping("handle1")
	@ResponseBody
	public Emplyee handle1() throws ParseException {
		Date hireDate = new SimpleDateFormat("yyyy-MM-dd").parse("2012-12-12");
		Emplyee e = new Emplyee("张三",hireDate,6012F,8,123456F);
		return e;
	}
	
}
