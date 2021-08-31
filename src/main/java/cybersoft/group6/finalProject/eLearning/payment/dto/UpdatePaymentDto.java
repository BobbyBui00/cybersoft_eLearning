package cybersoft.group6.finalProject.eLearning.payment.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePaymentDto {
	@NotBlank(message = "{payment.cardNumber.not-blank}")
	private String cardNumber;
	
	private String cardType;
	
	@NotBlank(message = "{payment.cardHolder.not-blank}")
	private String cardHolder;
	
	@NotBlank(message = "{payment.billingAddress.not-blank}")
	private String billingAddress;
	
	@NotBlank(message = "{payment.cvv.not-blank}")
	private String cvv;
	
	@NotBlank(message = "{payment.dateExpired.not-blank}")
	private String dateExpired;
	
	private String email;
	
	private String user;
}
