package com.fiixapp.service.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiixapp.models.UserModel;
import com.fiixapp.repositories.base.user.UserRepository;

@Service(value="UserService")
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserModel getUserById(long id) {
		return userRepository.findById(id);
	}

}
