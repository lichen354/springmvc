package sram.springmvc.lesson10.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import sram.springmvc.lesson10.pojo.Person;
/**
 * 使用commonsFileUpload完成文件上传
 * 
 * MultipartFile接口
 * 	 byte[] getBytes() 以字节数组形式返回文件内容
 * 	 String getContentType()	返回文件的内容类型
 * 	 InputStream getInputStream()	返回一个InputStream从中读取文件内容
 *   String getOriginalFilename()  返回文件原名
 * 	 long getSize()		以字节为单位 返回文件大小
 * 	 void transferTo(File destination)	将上传的文件保存在目标目录下
 * 
 * @author liche
 *
 */
@Controller
@RequestMapping("commonsFileUpload")
public class CommonsFileUploadController {

	@RequestMapping("upload")
	public String upload(HttpServletRequest request, @ModelAttribute Person person) {
		String name = person.getName();
		Integer age = person.getAge();
		System.out.println("name="+name+"age="+age);
		MultipartFile multfile = person.getImage();
		
		String fileName = multfile.getOriginalFilename();
		
		String contextPath = request.getServletContext().getRealPath("/image");
		File imageFile = new File(contextPath, fileName);
		
		//数据写入到目标文件中
		try {
			multfile.transferTo(imageFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		
		return "index";
	}
}
