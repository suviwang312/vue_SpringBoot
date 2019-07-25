package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.dao.UserDAO;
import com.neu.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;

	/**
	 * 验证用户信息（登录使用）
	 */
	public UserVO findByUserName(String cUsername) throws Exception {
		// TODO Auto-generated method stub
		try {
			UserVO userVO =  userDAO.findByUserName(cUsername);
			return userVO;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("class UserServiceImpl-->"
					+ "method findByUserName error", e);
		}
	}
	/**
	 * 获取用户列表
	 */
	public List<UserVO> userList(String cUsername) throws Exception {
		// TODO Auto-generated method stub
		try {
			return userDAO.userList(cUsername);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("class UserServiceImpl-->"
					+ "method findByUserName error", e);
		}
	}
	/**
	 * 插入用户
	 */
	public int insertUser(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		try {
			return userDAO.insertUser(userVO);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("class UserServiceImpl-->"
					+ "method insertUser error", e);
		}
	}

	/**
	 * 删除用户
	 */
	public int deleteUser(String cId) throws Exception {
		// TODO Auto-generated method stub
		try {
			return userDAO.deleteUser(cId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("class UserServiceImpl-->"
					+ "method deleteUser error", e);
		}
	}

	/**
	 * 更新用户
	 */
	public int updateUser(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		try {
			
			return userDAO.updateUser(userVO);
		} catch (Exception e) {
			throw new Exception(
					"class UserServiceImpl-->method updateUser error", e);
		} 
	}

	
	
}
