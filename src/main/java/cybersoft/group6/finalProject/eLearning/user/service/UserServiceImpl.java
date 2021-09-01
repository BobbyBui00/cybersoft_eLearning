package cybersoft.group6.finalProject.eLearning.user.service;

import org.springframework.stereotype.Service;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericServiceImpl;
import cybersoft.group6.finalProject.eLearning.user.dto.CreateNewUserDto;
import cybersoft.group6.finalProject.eLearning.user.dto.UpdateUserDto;
import cybersoft.group6.finalProject.eLearning.user.model.User;
import cybersoft.group6.finalProject.eLearning.user.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

	private UserRepository repository;
	
	@Override
	public User updateUserInfo(UpdateUserDto dto, Long userId) {
		// TODO Auto-generated method stub
		
		User updatedUser = repository.getById(userId);
		updatedUser.username(dto.getUsername())
					.password(dto.getPassword())
					.confirmPassword(dto.getConfirmPassword())
					.email(dto.getEmail())
					.exp(dto.getExp())
					.role(dto.getRole());
		
		
		
		return repository.save(updatedUser);
	}

	@Override
	public User createNewUser(CreateNewUserDto newUser) {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.username(newUser.getUsername())
			.password(newUser.getPassword())
			.confirmPassword(newUser.getConfirmPassword())
			.email(newUser.getEmail())
			.exp(newUser.getExp())
			.role(newUser.getRole());
		
		return repository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return repository.findByUsername(username);
	}

}
