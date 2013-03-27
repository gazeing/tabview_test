package com.example.tabview_test.http;

import android.os.AsyncTask;
import android.util.Log;

public class HttpAsyncTask extends AsyncTask<String, Void, String> {

	//String strUrl;
	HttpOperation ho;
	@Override
    protected void onPreExecute() {
        Log.i("AsyncTask", "onPreExecute");
    }
	@Override
	protected String doInBackground(String... arg0) {
		init();
		
		return PostData(arg0[0]);
		
		
	}
	private String PostData(String string) {
		// TODO Auto-generated method stub
		
		return ho.HttpClientPostMethod();
		//return ho.HttpClientGetMethod();
	}
	private void init() {
		// TODO Auto-generated method stub
		if (ho == null)
			ho = new HttpOperation("http://49.156.19.75");
		
	}
	public HttpAsyncTask(HttpOperation ho) {
		super();
		this.ho = ho;
	}
	protected void onPostExecute(String res) {
        if (isCancelled()) {
        	res = null;
        }
        Log.i("AsyncTask", "onPostExecute");
	}

}
