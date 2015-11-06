package com.example.mvp;

import com.example.mvp.model.ResponseBO;
import com.example.mvp.service.LoginApi;
import com.example.mvp.service.impl.LoginApiImpl;
import com.example.mvp.service.impl.ResponseApiImpl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private EditText edtName, edtPassword;
	private Button btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		edtName = (EditText) findViewById(R.id.edt_name);
		edtPassword = (EditText) findViewById(R.id.edt_password);
		btnLogin = (Button) findViewById(R.id.btn_login);
		btnLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String name = edtName.getText().toString();
		String password = edtPassword.getText().toString();
		// 实例化接口，MVP的核心思想就是针对接口编程而不是针对实现编程
		LoginApi api = new LoginApiImpl();
		// 调用接口请求服务器数据，服务器返回的数据回调在ResponseApiImpl的onSuccess（）方法里面,可以根据自己的需求来实现onStart（）和ondoinBack（）方法
		api.login(MainActivity.this, name, password, new ResponseApiImpl() {

			@Override
			public void onSuccess(ResponseBO response) {
				Toast.makeText(MainActivity.this, response.getResPonseCode() + ">>>>" + response.getResPonseMsg(), Toast.LENGTH_LONG)
						.show();
			}
		});
	}

}
