package com.example.macbook.labexam2;

import android.content.Intent;
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

public class Main2Activity extends AppCompatActivity {
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mToolbar);

        dbHandler = new MyDBHandler(Main2Activity.this, null, null, 1);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText mFirst_Name = (EditText) findViewById(R.id.txtFirst_Name);
                EditText mLast_Name = (EditText) findViewById(R.id.txtLast_Name);
                EditText mEMail = (EditText) findViewById(R.id.txtEMail);
                EditText mPhone_No = (EditText) findViewById(R.id.txtPhone_No);

                //add new member data into table

                Toast.makeText(Main2Activity.this,
                        "New member is added.",
                        Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(mIntent);
                Main2Activity.this.finish();
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
