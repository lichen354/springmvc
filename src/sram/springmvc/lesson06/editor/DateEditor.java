package sram.springmvc.lesson06.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 自定义PropertyEditor只需继承PropertyEditorSupport
 * @author liche
 *
 */
public class DateEditor extends PropertyEditorSupport {
	@Override
    public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("setAsText run");
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(text);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

	@Override
	public String getAsText() {
		return ((Date) getValue()).toString();
	}
}
