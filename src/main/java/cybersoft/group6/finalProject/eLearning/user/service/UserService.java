package cybersoft.group6.finalProject.eLearning.user.service;

import org.springframework.stereotype.Service;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericService;
import cybersoft.group6.finalProject.eLearning.user.dto.CreateNewUserDto;
import cybersoft.group6.finalProject.eLearning.user.dto.UpdateUserDto;
import cybersoft.group6.finalProject.eLearning.user.model.User;

@Service
public interface UserService extends GenericService<User, Long> {

	User updateUserInfo(UpdateUserDto dto, Long userId);
	User createNewUser(CreateNewUserDto newUser);
}
