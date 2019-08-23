package sram.springmvc.lesson05;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 使用jackson处理json
 * @author liche
 *
 */
@Controller
@RequestMapping("jacksonConvert")
public class JacksonConvertController {
	
	@RequestMapping("handle1")
	@ResponseBody
	public Map<String, Object> handle1( ) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("name", "张三");
		map.put("age", 12);
		return map;
	}

}
