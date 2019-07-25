package com.neu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neu.vo.UserVO;

public interface UserService {
	/**
	 * 验证用户信息（登录使用）
	 * @param cUsername
	 * @return
	 * @throws Exception
	 */
	public UserVO findByUserName(String cUsername) throws Exception;

	/**
	 * 获取用户列表
	 * @param cUsername
	 * @return
	 * @throws Exception
	 */
	public List<UserVO> userList(String cUsername)  throws Exception;
	/**
	 * 插入用户
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public int insertUser(UserVO userVO) throws Exception;
	/**
	 * 删除用户
	 * @param cId
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(String cId) throws Exception;
	/**
	 * 更新用户
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public int updateUser(UserVO userVO) throws Exception;
}
