package sumit.service;

import sumit.model.Register;
import sumit.repository.RegisterRepositoryImpl;

public class RegisterServiceImpl implements RegisterService{
    RegisterRepositoryImpl regRepo=new RegisterRepositoryImpl();
	@Override
	public boolean isRegisterUser(Register register) {
		// TODO Auto-generated method stub
		
		// String email=register.getEmail();
		// int index=email.indexOf("@gmail.com");
		// or 
		// int index=register.getEmail().indexOf("@gmail.com");
		if(register.getEmail().indexOf("@gmail.com")!=-1) {
			boolean b=regRepo.isRegisterUser(register);
			return b;
			
		}else {
			return false;
		}
		
		
	}
	
	

}
