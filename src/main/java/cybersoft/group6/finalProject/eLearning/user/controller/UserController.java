package cybersoft.group6.finalProject.eLearning.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.group6.finalProject.eLearning.commondata.model.ResponseHandler;
import cybersoft.group6.finalProject.eLearning.user.dto.CreateNewUserDto;
import cybersoft.group6.finalProject.eLearning.user.dto.UpdateUserDto;
import cybersoft.group6.finalProject.eLearning.user.model.User;
import cybersoft.group6.finalProject.eLearning.user.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
	
	private UserService service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllUser() {
		List<User> userList = service.findAll();
		
		if (userList.isEmpty())
			return ResponseHandler.getResponse("There is no data.", HttpStatus.OK);
		
		return ResponseHandler.getResponse(userList, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addNewUser(@Valid @RequestBody CreateNewUserDto newUser, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		User addUser = service.createNewUser(newUser);
		return ResponseHandler.getResponse(addUser, HttpStatus.OK);
	}
	
//	@PutMapping("/{user-id}")
//	public ResponseEntity<Object> updateUser(@Valid @RequestBody UpdateUserDto dto, @PathVariable("user-id") Long userId, BindingResult bindingResult) {
//		 
//		if (userId == null)
//			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
//		
//		if (bindingResult.hasErrors())
//			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
//		
//		User updateUser = service.updateUserInfo(dto, userId);
//		return ResponseHandler.getResponse(updateUser, HttpStatus.OK);
//	}
	
	@PutMapping("/{username}")
	public ResponseEntity<Object> updateUserByUsername(@Valid @RequestBody UpdateUserDto dto, @PathVariable("username") String username, BindingResult bindingResult){
		if(username.isEmpty())
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
		
		if(bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		System.out.println(username);
		
		User updatedUser = service.updateUser(dto, username);
		
		return ResponseHandler.getResponse(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{user-id}")
	public ResponseEntity<Object> deleteUser(@Valid @PathVariable("user-id") Long userId) {
		
		if(userId == null) 
			return ResponseHandler.getResponse("Id is invalid", HttpStatus.BAD_REQUEST);
		
		service.deleteById(userId);
		return ResponseHandler.getResponse("Delete successfully", HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<Object> findByUsername(@Valid @PathVariable("username") String username){
		if(username.isEmpty())
			return ResponseHandler.getResponse("Username is null", HttpStatus.BAD_REQUEST);
		
		User user = service.findByUsername(username);
		return ResponseHandler.getResponse(user, HttpStatus.OK);
	}
	
	
}
