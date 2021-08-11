package cybersoft.group6.finalProject.eLearning.payment.service;

import org.springframework.stereotype.Service;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericServiceImpl;
import cybersoft.group6.finalProject.eLearning.payment.dto.CreateNewPaymentDto;
import cybersoft.group6.finalProject.eLearning.payment.dto.UpdatePaymentDto;
import cybersoft.group6.finalProject.eLearning.payment.model.Payment;
import cybersoft.group6.finalProject.eLearning.payment.repository.PaymentRepository;
import cybersoft.group6.finalProject.eLearning.user.model.User;
import cybersoft.group6.finalProject.eLearning.user.repository.UserRepository;
import cybersoft.group6.finalProject.eLearning.util.MapDtoToModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaymentServiceImpl extends GenericServiceImpl<Payment, Long> implements PaymentService {

	private MapDtoToModel<Object, Payment> mapper;
	private UserRepository userRepository;
	private PaymentRepository repository;
	
	@Override
	public Payment addNewPayment(CreateNewPaymentDto dto) {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		payment = mapper.map(dto, payment);
		
		User paymentUser = userRepository.findByUsername(dto.getUser());
		payment.setUser(paymentUser);
		
		return repository.save(payment);
	}

	@Override
	public Payment findPaymentMethod(Long userId, Long paymentId) {
		// TODO Auto-generated method stub
		System.out.println("This user id" + userId);
		Payment payment = repository.findPaymentMethod(userRepository.findById(userId), paymentId);
		
		return payment;
	}

	@Override
	public void update(UpdatePaymentDto dto, Payment updatedPayment) {
		// TODO Auto-generated method stub

		updatedPayment = mapper.map(dto, updatedPayment);
		
		repository.save(updatedPayment);
		
	}

}
