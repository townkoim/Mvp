package com.example.mvp.service.impl;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.widget.Toast;

import com.example.mvp.async.MsgAsyncTask;
import com.example.mvp.common.APPConstants;
import com.example.mvp.service.LoginApi;
import com.example.mvp.service.ResponseApi;

/**
* @ClassName: LoginApiImpl  
* @Description: 实现 LoginApi，所有的login模块的业务逻辑都在此处，所以Activity界面无需任何复杂逻辑，MVP模式的核心逻辑
* @author libiao 
* @date 2015-11-6 下午3:22:15  
*
 */
public class LoginApiImpl implements LoginApi{
	
	@Override
	public void login(Activity activity, String name, String password, ResponseApi api) {
		//在这里你可以对传进来的数据进行校验，如果校验失败则可以作出相应的处理，我这里只是弹出提示
		if(name==null||"".equals(name)){
			Toast.makeText(activity, "用户名不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		if(password==null||"".equals(password)){
			Toast.makeText(activity, "密码不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		JSONObject json = new JSONObject();
		try {
			json.put("username", name);
			json.put("password", password);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		new MsgAsyncTask(activity, json.toString(), api, APPConstants.URL_LOGIN).execute();
	}

	@Override
	public void regist(Activity activity, String phone, String auCode, String password, ResponseApi api) {
		
	}
}
