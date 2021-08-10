package cybersoft.group6.finalProject.eLearning.payment.model;

import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "payment")
@Getter
@Setter
public class Payment extends AbstractEntity {

	@NotBlank(message = "{payment.cardNumber.not-blank}")
	private String cardNumber;
	
	@NotBlank(message = "{payment.cardHolder.not-blank}")
	private String cardHolder;
	
	@NotBlank(message = "{payment.billingAddress.not-blank}")
	private String billingAddress;
	
	@NotBlank(message = "{payment.cvv.not-blank}")
	private String cvv;
	
	@NotBlank(message = "{payment.dateExpired.not-blank}")
	private LocalDateTime dateExpired;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
