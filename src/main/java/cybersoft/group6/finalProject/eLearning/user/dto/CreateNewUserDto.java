package cybersoft.group6.finalProject.eLearning.user.dto;

import cybersoft.group6.finalProject.eLearning.user.utils.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNewUserDto {
	
	private String username;
	
	private String password;
	
	private String confirmPassword;
	
	private String email;
	
	private UserRole role;
	
	private String exp;
	
}
