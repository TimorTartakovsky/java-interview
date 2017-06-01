package com.fiixapp.repositories.base.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fiixapp.data.UserDatabase;
import com.fiixapp.models.UserModel;
import com.fiixapp.repositories.base.BaseUserRepository;

@Repository(value="UserRepository")
public class UserRepository extends BaseUserRepository {
	
	/**
	 * UserDatabase reference /created if not exist/ used to create users
	 */
	private UserDatabase userDatabase;
	private List<UserModel> users = new ArrayList<>();
	
	public UserRepository() {
		this.userDatabase = new UserDatabase();
		if(users.isEmpty()) {
			this.users = this.userDatabase.generateUsers();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.fiixapp.repositories.base.IRepository#getAll()
	 * This method returns all currently generated users 
	 */
	@Override
	public List<UserModel> getAll() {
		return users;
	}

	/* (non-Javadoc)
	 * @see com.fiixapp.repositories.base.IRepository#findById(java.lang.Object)
	 * This method allows to search for a users by Id (long)  
	 */
	@Override
	public UserModel findById(Long id) {
		for(UserModel user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
