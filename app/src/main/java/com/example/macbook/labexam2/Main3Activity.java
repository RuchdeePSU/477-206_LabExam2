package com.example.macbook.labexam2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    int selMember_ID;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //set toolbar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(mToolbar);

        //get member_id from MainActivity
        Intent mIntent = getIntent();
        selMember_ID = mIntent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        dbHandler = new MyDBHandler(Main3Activity.this, null, null, 1);

        EditText mFirst_Name = (EditText) findViewById(R.id.txtFirst_Name_Update);
        EditText mLast_Name = (EditText) findViewById(R.id.txtLast_Name_Update);
        EditText mEMail = (EditText) findViewById(R.id.txtEMail_Update);
        EditText mPhone_No = (EditText) findViewById(R.id.txtPhone_No_Update);

        Cursor searchResult = dbHandler.getMemberbyID(selMember_ID);
        searchResult.moveToFirst();
        mFirst_Name.setText(searchResult.getString(searchResult.getColumnIndex(dbHandler.COLUMN_FIRST_NAME)));
        mLast_Name.setText(searchResult.getString(searchResult.getColumnIndex(dbHandler.COLUMN_LAST_NAME)));
        mEMail.setText(searchResult.getString(searchResult.getColumnIndex(dbHandler.COLUMN_EMAIL)));
        mPhone_No.setText(searchResult.getString(searchResult.getColumnIndex(dbHandler.COLUMN_PHONE_NO)));

        //Update Member
        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update existing member


                Toast.makeText(Main3Activity.this,
                        "Member is updated.",
                        Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(mIntent);
                Main3Activity.this.finish();
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem mnuAdd = menu.findItem(R.id.mnuAdd);
        mnuAdd.setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnuExit) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
