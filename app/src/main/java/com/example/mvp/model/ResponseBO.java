package com.example.mvp.model;

/**
* @ClassName: ResponseBO  
* @Description: 服务器的返回数据实体类 
* @author libiao 
* @date 2015-11-6 下午2:39:15  
*
 */
public class ResponseBO {
	public int resPonseCode; //返回码，200代表返回成功
	private String resPonseMsg; //返回的Message
	public ResponseBO() {
	}
	public ResponseBO(int resPonseCode, String resPonseMsg) {
		super();
		this.resPonseCode = resPonseCode;
		this.resPonseMsg = resPonseMsg;
	}
	public int getResPonseCode() {
		return resPonseCode;
	}
	public void setResPonseCode(int resPonseCode) {
		this.resPonseCode = resPonseCode;
	}
	public String getResPonseMsg() {
		return resPonseMsg;
	}
	public void setResPonseMsg(String resPonseMsg) {
		this.resPonseMsg = resPonseMsg;
	}
	
}
