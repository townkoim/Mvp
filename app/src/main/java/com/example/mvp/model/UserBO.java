package com.example.mvp.model;

/**
* @ClassName: UserBO  
* @Description: 用户登录实体类 
* @author libiao 
* @date 2015-11-6 下午2:39:55  
*
 */
public class UserBO {
	private String name; //用户名
	private String password; //密码
	public UserBO() {
		// TODO Auto-generated constructor stub
	}
	public UserBO(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
