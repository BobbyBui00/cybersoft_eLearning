package cybersoft.group6.finalProject.eLearning.payment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cybersoft.group6.finalProject.eLearning.payment.model.Payment;
import cybersoft.group6.finalProject.eLearning.user.model.User;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	@Query("SELECT p FROM Payment p WHERE p.user = ?1 and p.id = ?2")
	Payment findPaymentMethod(Optional<User> optional, Long paymentId);
	
	@Query("SELECT p FROM Payment p WHERE p.user = ?1")
	List<Payment> findPaymentMethodByUsername(User user);
	
	Payment findPaymentByCardNumber(String cardNumber);
	
}
