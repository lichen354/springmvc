package sram.springmvc.lesson06.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{
	private DateFormat df;

	public DateConverter(String pattern) {
		df = new SimpleDateFormat(pattern);
	}

	@Override
	public Date convert(String source) {
		System.out.println("convert run");
		try {
			return df.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
