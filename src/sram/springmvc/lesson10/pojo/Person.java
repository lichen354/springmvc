package sram.springmvc.lesson10.pojo;

import org.springframework.web.multipart.MultipartFile;


public class Person {
	private String name;
	private Integer age;
	//需要上传的属性定义为MultipartFile类型
	MultipartFile image;
	
	public Person() {
		
	}
	public Person(String name, Integer age, MultipartFile image) {
		super();
		this.name = name;
		this.age = age;
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
}
