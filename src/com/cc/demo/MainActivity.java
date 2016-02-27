package com.cc.demo;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

	HorizontalScrollViewEx mListContainer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    
    void init() {
    	setContentView(R.layout.activity_horizontal_view); 
    	LayoutInflater inflater = getLayoutInflater();
    	mListContainer = (HorizontalScrollViewEx) findViewById(R.id.container);
    	@SuppressWarnings("deprecation")
		final int screeWidth = getWindowManager().getDefaultDisplay().getWidth();
    	for (int i = 0; i < 3; i++){
    		ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.horizontal_page, mListContainer,false);
//    		layout.getLayoutParams().width = screeWidth;
    		TextView textView = (TextView) layout.findViewById(R.id.title);
    		textView.setText("page"+(i+1));
    		layout.setBackgroundColor(Color.rgb(255/(i+1), 255/(i+1), 255/(i+1)));
    		createList(layout);
    		mListContainer.addView(layout); 
    	}
    }
    
    void createList(ViewGroup layout) {
    	ListView listView = (ListView) layout.findViewById(R.id.list);
    	ArrayList<String> datas = new ArrayList<String>();
    	for (int i = 0; i < 50 ; i++) {
    		datas.add("name" + i);
    		
    	}
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, datas);
    	listView.setAdapter(adapter);
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
