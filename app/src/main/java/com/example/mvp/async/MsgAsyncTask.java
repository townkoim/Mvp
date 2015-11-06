package com.example.mvp.async;

import android.app.Activity;
import android.content.Context;

import com.example.mvp.model.ResponseBO;
import com.example.mvp.service.ResponseApi;
import com.example.mvp.util.HttpUtil;

/**
 * 
* @ClassName: MsgAsyncTask  
* @Description:  发送普通字符串给服务器的异步任务  
* @author libiao 
* @date 2015-11-6 下午2:37:26  
*
 */
public class MsgAsyncTask extends WeakAsyncTask<Void, Void, ResponseBO, Context>{
	private String json; 
	private ResponseApi api; 
	private String url; 
	/**
	 * @Title:MsgAsyncTask
	 * @Description:构造方法
	 * @param activity Activiyt对象
	 * @param json 要发送给服务器端的字符串
	 * @param api 回调接口
	 * @param url 服务器地址
	 */
	public MsgAsyncTask(Activity activity,String json,ResponseApi api,String url) {
		super(activity);
		this.json=json;
		this.api=api;
		this.url=url;
	}
	@Override
	protected void onPreExecute(Context target) {
		// TODO Auto-generated method stub
		super.onPreExecute(target);
		api.onStart();
	}
	@Override
	protected ResponseBO doInBackground(Context target, Void... params) {
		api.ondoinBack();
		return HttpUtil.getInstance().post(json, url);
	}
	@Override
	protected void onPostExecute(Context target, ResponseBO result) {
		super.onPostExecute(target, result);
		api.onSuccess(result);
	}
	
}
