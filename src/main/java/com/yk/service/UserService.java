package com.yk.service;

import com.yk.orm.PageVO;
import com.yk.po.User;

public interface UserService {
	 void selectUserById();
	 
	 void insertUser();
	 
	 void selectByPage();

}
