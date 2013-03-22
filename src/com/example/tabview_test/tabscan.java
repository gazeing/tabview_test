package com.example.tabview_test;

import java.util.ArrayList;
import java.util.List;

import com.example.tabview_test.database.Qrcode;
import com.example.tabview_test.database.QrcodeDataOperator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class tabscan extends Activity {

	private List<String> data = new ArrayList<String>();
	protected List<String> getData() {
		return data;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		scanProcess();
	}
	@SuppressWarnings("deprecation")
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode ==0) {
			if (resultCode == RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				//String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
//				Bundle reBl= intent.getExtras();
//				System.out.println(reBl.toString());
//				Bundle testBl = (Bundle)reBl.toString();
//				testBl.
//				Toast.makeText(getApplicationContext(), contents, Toast.LENGTH_SHORT).show();  
//				Intent intentCon = new Intent();
//				intentCon.setClass(tabscan.this, tabone.class);
//				//通过Bundle来获取数据,通过key-Value的方式放入数据
//				Bundle bl = new Bundle();
//				bl.putString("contents", contents);
//				//将Bundle放入Intent传入下一个Activity
//				intentCon.putExtras(bl);
				((MainActivity) this.getParent()).setIntentAll(intent);
				
				QrcodeDataOperator qdo = ((MainActivity) this.getParent()).getQdo();
				qdo.insert(new Qrcode(contents));
				//startActivity(intentCon);
				//tabscan.this.finish();
			} else if (resultCode == RESULT_CANCELED) {
			// Handle cancel
				System.out.println(" scan error!");
		}
		((MainActivity) this.getParent()).getTabHost().setCurrentTabByTag("History");
	}
	}
	
	protected void scanProcess(){
		Intent intent =new Intent("com.google.zxing.client.android.SCAN");//调用扫描的actity,这里其实只是转到刚才安装的BarcodeScanner3程序的中一个actity
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");//输入参数，（扫描类型，..二维码）
		startActivityForResult(intent, 0);//启动intent
	}
}

