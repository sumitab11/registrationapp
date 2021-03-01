package sumit.repository;

import sumit.model.LoginModel;
import sumit.model.Register;

public interface RegisterRepository {
	public boolean isRegisterUser(Register register);
	public boolean isValidateUser(LoginModel loginmodel);
	
}
