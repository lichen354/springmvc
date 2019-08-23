package sram.springmvc.lesson05;

import java.net.URI;
import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HttpEntity<T>/ResponseEntity<T>
 * 接收请求(头+体)/返回响应(头+体)
 * @author liche
 *
 */
@Controller
@RequestMapping("httpEntityResponseEntity")
public class HttpEntityResponseEntityController {
	/*
	 * HttpEntity接收请求(头+体)
	 */
	@RequestMapping(value = "/handle1")
	public String handle1(HttpEntity<String> httpEntity){                             
	     String headerStr = httpEntity.getHeaders().toString();
	     System.out.println(headerStr);
	     System.out.println(httpEntity.getBody());
	      return "index";
	}

	/*
	 * 返回ResponseEntity响应(头+体)
	 */
	@RequestMapping("handle2")   
	public ResponseEntity<String> handle2(){   
	    HttpHeaders headers = new HttpHeaders();   
	    MediaType mType=new MediaType("text","html",Charset.forName("UTF-8"));   
	    headers.setContentType(mType);   
	    ResponseEntity<String> resEntity=null;   
	    String body = new String("test");   
	    resEntity=new ResponseEntity<String>(body,headers, HttpStatus.OK);   
	    return resEntity;   
	}

}
