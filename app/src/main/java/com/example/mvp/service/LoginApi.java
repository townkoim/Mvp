package com.example.mvp.service;

import android.app.Activity;

/**
 * @ClassName: LoginApi
 * @Description: 
 *               登录的接口，如果项目比较大，可以采用模块化命名，在这个接口下，可以有当前模块的所有需要与服务器交互的方法(根据api接口文档来封装
 *               ) ,比如我接口下面就一个登陆的方法，一个注册的方法（注册的方法的具体逻辑没有实现）
 * @author libiao
 * @date 2015-11-6 下午3:12:14
 * 
 */
public interface LoginApi {
	/**
	 * @Title: login 
	 * @Description: 登陆的方法
	 * @param activity activity对象
	 * @param name 用户名
	 * @param password 密码
	 * @param api 回调接口
	 * @return: void
	 */
	public void login(Activity activity, String name, String password, ResponseApi api);

	public void regist(Activity activity, String phone, String auCode, String password, ResponseApi api);
}
