package sumit.service;

import sumit.model.LoginModel;
import sumit.repository.RegisterRepositoryImpl;

public class LoginServiceImpl implements LoginService {
	RegisterRepositoryImpl regRepo=new RegisterRepositoryImpl();
	@Override
	public boolean isValidateUser(LoginModel model) {
		
		return regRepo.isValidateUser(model);
	
	
	}

}
 