package com.example.mvp.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.example.mvp.model.ResponseBO;

public class HttpUtil {
	private final static String REQUEST_MOTHOD = "POST";
	private final static int TIME_OUT = 15000;

	private static HttpUtil instance = null;

	private HttpUtil() {
	}

	public static HttpUtil getInstance() {
		if (instance == null) {
			instance = new HttpUtil();
		}
		return instance;
	}

	public ResponseBO post(String json, String url) {
		ResponseBO bo = new ResponseBO();
		HttpURLConnection connection = getConnection(url);
		try {
			connection.setRequestProperty("Content-Length", String.valueOf(json.getBytes().length));
			OutputStream os = connection.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.flush();
			int code = connection.getResponseCode();
			bo.setResPonseCode(code);
			if (connection.getResponseCode() == 200) {
				// 获取响应的输入流对象
				InputStream is = connection.getInputStream();
				// 创建字节输出流对象
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				// 定义读取的长度
				int len = 0;
				// 定义缓冲区
				byte buffer[] = new byte[1024];
				// 按照缓冲区的大小，循环读取
				while ((len = is.read(buffer)) != -1) {
					// 根据读取的长度写入到os对象中
					baos.write(buffer, 0, len);
				}
				// 释放资源
				is.close();
				baos.close();
				bo.setResPonseMsg(new String(baos.toByteArray()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.disconnect();
		return bo;
	}

	private HttpURLConnection getConnection(String path) {
		HttpURLConnection connection = null;
		// 初始化connection
		try {
			// 根据地址创建URL对象
			URL url = new URL(path);
			// 根据URL对象打开链接
			connection = (HttpURLConnection) url.openConnection();
			// 设置请求的方式
			connection.setRequestMethod(REQUEST_MOTHOD);
			// 发送POST请求必须设置允许输入，默认为true
			connection.setDoInput(true);
			// 发送POST请求必须设置允许输出
			connection.setDoOutput(true);
			// 设置不使用缓存
			connection.setUseCaches(false);
			// 设置请求的超时时间
			connection.setReadTimeout(TIME_OUT);
			connection.setConnectTimeout(TIME_OUT);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
