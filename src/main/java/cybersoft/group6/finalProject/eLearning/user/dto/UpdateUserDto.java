package cybersoft.group6.finalProject.eLearning.user.dto;

import javax.validation.constraints.Size;

import cybersoft.group6.finalProject.eLearning.payment.model.Payment;
import cybersoft.group6.finalProject.eLearning.user.utils.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDto {
	
	@Size(min = 3, max = 100, message = "{user.username.size}")
	private String username;
	
	private String password;
	
	private String confirmPassword;
	
	private String email;
	
	private UserRole role;
	
	private String exp;
	

}
