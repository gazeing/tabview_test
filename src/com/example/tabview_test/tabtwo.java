package com.example.tabview_test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class tabtwo extends Activity {
	private List<String> data = new ArrayList<String>();
	protected List<String> getData() {
		return data;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListView lView = new ListView(this);
		data.add("FAQ");
		data.add("Acknowledgement");
		data.add("Terms and Lisences");
		data.add("About Us");
		ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData());
		lView.setAdapter(adp);
		setContentView(lView);
	}
}
