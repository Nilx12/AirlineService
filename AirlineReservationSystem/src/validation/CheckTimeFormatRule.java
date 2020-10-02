package validation;

import java.time.LocalTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CheckTimeFormatRule implements ConstraintValidator<CheckTimeFormat, String> {


	@Override
	public boolean isValid(String time, ConstraintValidatorContext arg1) {
		
		if(time == null)
			return false;
		
		if(time.length() != 5)
			return false;
		
		if(!Character.isDigit(time.charAt(0)) || !Character.isDigit(time.charAt(1))
				|| !Character.isDigit(time.charAt(3)) || !Character.isDigit(time.charAt(4))) 
			return false;
		
		if(time.charAt(2) != ':')
			return false;
		
		int hours = Integer.parseInt(time.substring(0, 2));
		if(hours < 0 || hours > 23)
			return false;
		
		int minutes = Integer.parseInt(time.substring(3, 5));
		if(minutes < 0 || minutes > 59)
			return false;
		
		return true;
	}

}
