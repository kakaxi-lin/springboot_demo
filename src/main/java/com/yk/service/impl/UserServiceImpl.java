package com.yk.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yk.dao.UserMapper;
import com.yk.orm.PageVO;
import com.yk.po.User;
import com.yk.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	@Override
	public void selectUserById() {
		System.out.println("selectUserById...");
		User xx = userMapper.selectByPrimaryKey(9);
		System.out.println(xx);
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void insertUser() {
		for (int i = 0; i < 10; i++) {
			User user=new User();
			user.setUname("测试插入"+i);
			user.setUpwd("666");
			userMapper.insert(user);
		}
	}
	@Override
	public void selectByPage() {
		/*List<User> userList = userMapper.selectAll(new PageVO<User>());
		for(User u:userList){
			System.out.println(u);
		}*/
	}

}
