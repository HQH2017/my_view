package com.example.my_ui;

import com.example.my_ui.Topbar.TopbarClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
//�Զ���view дͷ��ģ��
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Topbar topbar=(Topbar) findViewById(R.id.topbar);
		topbar.setTopbarClickListener(new TopbarClickListener() {
			
			@Override
			public void rightClick() {
				Toast.makeText(MainActivity.this, "����", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void leftClick() {
				Toast.makeText(MainActivity.this, "ǰ��", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
