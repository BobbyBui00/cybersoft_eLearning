package cybersoft.group6.finalProject.eLearning.util;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorsUtils {

	public static List<String> getErrorsMessage(BindingResult bindingResult)
	{
		List<String> messages=new LinkedList<>();
		List<ObjectError> errors=bindingResult.getAllErrors();
		
		for(ObjectError error : errors)
		{
			messages.add(error.getDefaultMessage());
		}
		
		return messages;
	}
	
	public static List<String> errorsOf(String message)
	{
		List<String> messages=new LinkedList<String>();
		messages.add(message);
		return messages;
	}
}
