package com.example.mvp.service.impl;

import com.example.mvp.service.ResponseApi;

/**
* @ClassName: ResponseApiImpl  
* @Description: 实现了  ResponseApi接口，在调用ResponseApi接口的时候，实例化此类，可以不用必须实现onStart（），ondoinBack（）方法
* @author libiao 
* @date 2015-11-6 下午3:21:04  
*
 */
public abstract class ResponseApiImpl implements ResponseApi {
	@Override
	public void onStart() {

	}

	@Override
	public void ondoinBack() {

	}
}
