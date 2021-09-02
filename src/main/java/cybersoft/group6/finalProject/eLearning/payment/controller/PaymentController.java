package cybersoft.group6.finalProject.eLearning.payment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.group6.finalProject.eLearning.commondata.model.ResponseHandler;
import cybersoft.group6.finalProject.eLearning.payment.dto.CreateNewPaymentDto;
import cybersoft.group6.finalProject.eLearning.payment.dto.UpdatePaymentDto;
import cybersoft.group6.finalProject.eLearning.payment.model.Payment;
import cybersoft.group6.finalProject.eLearning.payment.service.PaymentService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/payment")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

	private PaymentService service;
	
	@GetMapping("")
	public ResponseEntity<Object> getAllPaymentInfo() {
		List<Payment> paymentList = service.findAll();
		
		if (paymentList.isEmpty())
			return ResponseHandler.getResponse("There is no payment available", HttpStatus.OK);
		
		return ResponseHandler.getResponse(paymentList, HttpStatus.OK);
		
	}
	
	@GetMapping("/{user-username}")
	public ResponseEntity<Object> getAllPaymentByUsername(@Valid @PathVariable("user-username") String username) {
		
		List<Payment> allUserPayment = service.findPaymentByUser(username);
		
		if(allUserPayment.isEmpty())
			return ResponseHandler.getResponse(HttpStatus.OK);
		
		return ResponseHandler.getResponse(allUserPayment, HttpStatus.OK);
	}
	
	@GetMapping("search-payment/{payment-cardNumber}")
	public ResponseEntity<Object> getPaymentByCardNumber(@Valid @PathVariable("payment-cardNumber") String cardNumber) {
		
		Payment foundPayment = service.findPaymentUsingCardNumber(cardNumber);
		
		if (foundPayment == null)
			return ResponseHandler.getResponse("There is no data", HttpStatus.OK);
		
		return ResponseHandler.getResponse(foundPayment, HttpStatus.OK);
		
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addNewPaymentMethod(@Valid @RequestBody CreateNewPaymentDto dto, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		Payment newPayment = service.addNewPayment(dto);
		return ResponseHandler.getResponse(newPayment, HttpStatus.OK);
	}
	
	@PutMapping("/{user-id}/{payment-id}")
	public ResponseEntity<Object> updatedPaymentMethod(@Valid @PathVariable("user-id") Long userId, @PathVariable("payment-id") Long paymentId, @RequestBody UpdatePaymentDto dto, BindingResult bindingResult) {
		
		if(userId == null)
			return ResponseHandler.getResponse("Invalid user id", HttpStatus.BAD_REQUEST);
		
		if (paymentId == null)
			return ResponseHandler.getResponse("invalid payment id", HttpStatus.BAD_REQUEST);
		
		if(bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		Payment updatedPayment = service.findPaymentMethod(userId, paymentId);
		service.update(dto, updatedPayment);
		return ResponseHandler.getResponse("Update payment method successfully.", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{user-id}/{payment-id}")
	public ResponseEntity<Object> deletePaymentMethod(@Valid @PathVariable("user-id") Long userId, @PathVariable("payment-id") Long paymentId) {
		
		if(userId == null)
			return ResponseHandler.getResponse("Invalid user id", HttpStatus.BAD_REQUEST);
		
		if (paymentId == null)
			return ResponseHandler.getResponse("invalid payment id", HttpStatus.BAD_REQUEST);
		
		Payment deletePayment = service.findPaymentMethod(userId, paymentId);
		service.deleteById(deletePayment.getId());
		return ResponseHandler.getResponse("Delete payment method successfully", HttpStatus.OK);
		
	}
	
	
	
}
