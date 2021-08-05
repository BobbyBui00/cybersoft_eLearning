package cybersoft.group6.finalProject.eLearning.payment.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
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
	
	private LocalDate dateExpired;
	
}
