package cybersoft.group6.finalProject.eLearning.payment.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import cybersoft.group6.finalProject.eLearning.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment extends AbstractEntity {

	private String cardNumber;
	
	private String cardHolder;
	
	private String billingAddress;
	
	private String cvv;
	
	private LocalDateTime dateExpired;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
