package com.neu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.apache.catalina.mapper.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.Session;
import com.neu.core.util.IDUtil;
import com.neu.service.UserService;
import com.neu.vo.UserVO;

/**
 * 包含用户登录还有主页面
 * @author wangs
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	/**
	 * 引入service层
	 */
	@Autowired
	private UserService userService;
	
	
	//@RequestMapping(value="/index")
	@GetMapping(value="/index")//是get方法获取
	public Map<String,Object> getIndex(){
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("code", 200);
		retMap.put("message", "Hellowrold");
		return retMap;
	}
	/**
	 * 用户登录
	 * @param request
	 * @param cUsername
	 * @param cPwd
	 * @return
	 */
	@PostMapping(value="/login")
	public Map<String,Object> login(HttpServletRequest request,
			String cUsername,String cPwd){
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		try {
			UserVO userVO = userService.findByUserName(cUsername);
			if (userVO!=null&&cPwd.equals(userVO.getcPwd())) {
				
				retMap.put("code", 200);
				retMap.put("token", cUsername);
				retMap.put("msg","登录成功");
				retMap.put("token","adminxxxx");
			}else {
				retMap.put("code", 500);
				retMap.put("msg", "用户名密码错误");
			}
		} catch (Exception e) {
			retMap.put("code", 500);
			retMap.put("msg","服务器内部错误");
		}
		return retMap;
	}
	/**
	 * 获取用户列表信息（包含查询用户）
	 * @param cUsername
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value="/getUserList")
	public Map<String, Object> getUserList(String cUsername) throws Exception{
		Map<String, Object> retMap = new HashMap<String, Object>();	
		try {
			List<UserVO> list =userService.userList(cUsername);
			retMap.put("rows", list);
			retMap.put("code", 200);
			retMap.put("msg","获取用户列表成功");
			
		}catch(Exception e) {
			retMap.put("code", 500);
			retMap.put("msg","服务器内部错误");
		}
		return retMap;	
	}
	
	/**
	 * 新增用户
	 * 对数据库进行增加字段操作
	 * @param request
	 * @param userVO
	 * @return
	 */
//  @RequestMapping(value = "/insert", method = RequestMethod.POST)
	@PostMapping(value = "/insertUser")
    public Map<String, Object> insertUser(HttpServletRequest request,UserVO userVO){
    Map<String, Object> retMap = new HashMap<String, Object>();
    userVO.setcId(IDUtil.getID());//获取id
    request.getSession().getId();
    try {
		
		int result =userService.insertUser(userVO);
		if (result==1) {
			retMap.put("code",200);
			retMap.put("msg","新增用户成功!");
		}else {
			retMap.put("code",500);
			retMap.put("msg","新增用户失败!");
		}
	} catch (Exception e) {
		retMap.put("code", 500);
		retMap.put("msg","服务器内部错误");
	}
	return retMap;
    
	}
	/**
	 * 根据用户id进行删除用户
	 * 对数据库进行的删除操作
	 * @param cId
	 * @return
	 */
//  @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
	@ResponseBody
	@RequestMapping(value="/delete")
    public Map<String, Object> deleteUser(String cId){
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			int result = userService.deleteUser(cId);
			if (result==1) {
				retMap.put("code",200);
				retMap.put("msg","用户删除成功");
			}else {
				retMap.put("code",500);
				retMap.put("msg","用户删除失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			retMap.put("code", 500);
			retMap.put("msg","服务器内部错误");
		}
		return retMap;
		
	}
	/**
	 * 对用户信息进行修改
	 * 对数据进行修改的操作
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
//  @RequestMapping(value = "/user/updateUser", method = RequestMethod.POST)
//	@ResponseBody
//	@RequestMapping(value="/updateUser")
	@PostMapping(value = "/updateUser")
    public Map<String,Object> updateUser(UserVO userVO) throws Exception {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			int flag = userService.updateUser(userVO);
			if (flag==1) {
				retMap.put("code",200);
				retMap.put("msg","用户信息更新成功");
			}else {
				retMap.put("code",500);
				retMap.put("msg","用户信息更新失败");
			}
		} catch (Exception e) {
			retMap.put("code", 500);
			retMap.put("msg","服务器内部错误");
			
		}
		return retMap;
    }
}
