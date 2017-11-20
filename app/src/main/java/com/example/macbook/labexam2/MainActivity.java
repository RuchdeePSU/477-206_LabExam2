package com.example.macbook.labexam2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    MyDBHandler dbHandler;
    ArrayList<String> listAllMembers;
    ArrayList<Integer> listAllMembersID;
    ArrayAdapter<String> memberAdapter = null;
    public static final String EXTRA_MESSAGE = "Member_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set toolbar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        //connect to database
        dbHandler = new MyDBHandler(MainActivity.this, null, null, 1);


        mListView = (ListView) findViewById(R.id.lvMembers);
        memberAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAllMembers);
        mListView.setAdapter(memberAdapter);

        //set context menu to ListView
        registerForContextMenu(mListView);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem mnuExit = menu.findItem(R.id.mnuExit);
        mnuExit.setVisible(false);
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
        if (item.getItemId() == R.id.mnuAdd) {
            //call Main2Activity
            Intent add_member_activity = new Intent(this, Main2Activity.class);
            startActivity(add_member_activity);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //get current position and member_id
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int selMember_ID = listAllMembersID.get(info.position);

        //edit member
        if (item.getItemId() == R.id.mnuEdit) {
            Intent edit_member_activity = new Intent(this, Main3Activity.class);
            edit_member_activity.putExtra(EXTRA_MESSAGE, selMember_ID);
            startActivity(edit_member_activity);
        }

        //delete member
        if (item.getItemId() == R.id.mnuDelete) {
            //display confirmation dialog

        }
        return super.onContextItemSelected(item);
    }
}
