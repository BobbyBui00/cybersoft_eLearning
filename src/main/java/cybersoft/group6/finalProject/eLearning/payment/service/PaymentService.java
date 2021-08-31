package cybersoft.group6.finalProject.eLearning.payment.service;

import java.util.List;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericService;
import cybersoft.group6.finalProject.eLearning.payment.dto.CreateNewPaymentDto;
import cybersoft.group6.finalProject.eLearning.payment.dto.UpdatePaymentDto;
import cybersoft.group6.finalProject.eLearning.payment.model.Payment;

public interface PaymentService extends GenericService<Payment, Long> {

	Payment addNewPayment(CreateNewPaymentDto dto);
	Payment findPaymentMethod(Long userId, Long paymentId);
	void update(UpdatePaymentDto dto, Payment updatedPayment);
	List<Payment> findPaymentByUser(String username);
	Payment findPaymentUsingCardNumber(String cardNumber);
	
}
