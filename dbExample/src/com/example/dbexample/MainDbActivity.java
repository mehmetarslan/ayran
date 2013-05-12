package com.example.dbexample;

import com.example.utilities.DatabaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteQueryBuilder;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainDbActivity extends Activity {
	private EditText txt1;
	private EditText txt2;
	private EditText txt3;
	private Button btn1;
	private DatabaseHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_db);
		txt1= (EditText) findViewById(R.id.data1);
		txt2= (EditText) findViewById(R.id.data2);
		txt3= (EditText) findViewById(R.id.data3);
		btn1 = (Button) findViewById(R.id.btn1);
		dbHelper = new DatabaseHelper(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_db, menu);
		return true;
	}
	public int saveToDB(View view)
	{
		try {
			dbHelper.openDataBase();
			dbHelper.myDataBase.execSQL("INSERT INTO TEST VALUES(1,'"+txt1.getText()+"','"+txt2.getText()+"','"+txt3.getText()+"')");
			dbHelper.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

}
