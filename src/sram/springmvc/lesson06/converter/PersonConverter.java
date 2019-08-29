package sram.springmvc.lesson06.converter;


import org.springframework.core.convert.converter.Converter;

import sram.springmvc.lesson06.pojo.Person;

public class PersonConverter implements Converter<String, Person>{
	
	@Override
	public Person convert(String source) {
		String[] s = source.split("-");
		Person p = new Person();
		p.setName(s[0]);
		p.setAge(Integer.parseInt(s[1]));
		p.setSex(s[2]);
		return p;
	}

	

}
