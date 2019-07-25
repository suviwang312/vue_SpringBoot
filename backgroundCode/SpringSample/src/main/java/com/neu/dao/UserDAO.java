package com.neu.dao;

import java.util.List;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.junit.validator.PublicClassValidator;

import com.neu.vo.UserVO;


public interface UserDAO {
	/**
	 * 验证用户信息（登录使用）
	 * @param cUsername
	 * @return
	 * @throws Exception
	 */
	public UserVO findByUserName(@Param("cUsername")String cUsername)  throws Exception;
	/**
	 * 获取用户列表
	 * @param cUsername
	 * @return
	 * @throws Exception
	 */
	public List<UserVO> userList(@Param("cUsername")String cUsername)  throws Exception;

	/**
	 * 插入用户
	 * @param userVO
	 * @return
	 */
	public int insertUser(@Param("userVO")UserVO userVO);
	/**
	 * 删除用户 
	 * @param cId
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(@Param("cId")String cId) throws Exception;

	
	/**
	 * 更新用户
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public int updateUser(@Param("userVO")UserVO userVO) throws Exception;

}
