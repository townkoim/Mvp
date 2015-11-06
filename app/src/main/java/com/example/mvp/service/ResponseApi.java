package com.example.mvp.service;

import com.example.mvp.model.ResponseBO;

/**
* @ClassName: ResponseApi  
* @Description: 异步任务的回调接口类，相当于Asynctask中的三个方法 
* @author libiao 
* @date 2015-11-6 下午3:04:22  
*
 */
public interface ResponseApi {
	/**
	 * @Title: onStart 
	 * @Description: 异步任务启动的时候。相当于AsyncTask中的onstart()方法
	 * @return: void
	 */
	public void onStart();
	
	/**
	 * @Title: ondoinBack 
	 * @Description: 异步任务执行过程中。相当于AsyncTask中的doInBackground()方法
	 * @return: void
	 */
	public void ondoinBack();

	/**
	 * @Title: onSuccess 
	 * @Description: 异步任务执行完毕的方法，相当于AsyncTask中的onPostExecute()方法，实现此接口。这个方法们无论服务器返回的状态吗是多少，都会进入此方法
	 * @param response
	 * @return: void
	 */
	public void onSuccess(ResponseBO response);
}
