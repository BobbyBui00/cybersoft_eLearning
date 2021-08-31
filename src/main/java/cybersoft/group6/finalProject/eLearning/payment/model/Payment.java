package cybersoft.group6.finalProject.eLearning.payment.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import cybersoft.group6.finalProject.eLearning.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "elearning_payment")
@Getter
@Setter
public class Payment extends AbstractEntity {

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	private String email;
}
