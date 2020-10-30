package nongsan.webmvc.service;

import java.sql.SQLException;

import nongsan.webmvc.dao.impl.LoginDao;
import nongsan.webmvc.model.User;

public interface LoginBO {
	LoginDao loginDao = new LoginDao();
	public User checkLogin(String username, String password) ;
		
}
