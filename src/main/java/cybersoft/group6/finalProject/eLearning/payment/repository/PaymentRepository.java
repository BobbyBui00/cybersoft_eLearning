package cybersoft.group6.finalProject.eLearning.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cybersoft.group6.finalProject.eLearning.payment.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
