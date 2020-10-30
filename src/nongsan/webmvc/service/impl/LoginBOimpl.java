package nongsan.webmvc.service.impl;

import java.sql.SQLException;

import nongsan.webmvc.dao.impl.LoginDao;
import nongsan.webmvc.model.User;
import nongsan.webmvc.service.LoginBO;

public class LoginBOimpl implements LoginBO{
	LoginDao loginDao = new LoginDao();
	public User checkLogin(String username, String password){
		return loginDao.checkLogin(username, password);
	}
}
