package com.wq.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_save ;
    private Button btn_getAll ;
    private Button btn_get ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_getAll = (Button) findViewById(R.id.btn_getAll);
        btn_get = (Button) findViewById(R.id.btn_get);

        btn_save.setOnClickListener(this);
        btn_getAll.setOnClickListener(this);
        btn_get.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId() ;
        switch (id){
            case R.id.btn_save:
                save();
                break;
            case R.id.btn_getAll:
                getAll();
                break ;
            case R.id.btn_get:
                get();
                break ;
        }
    }
    private void save(){
        User user1 = new User("abc1",20);
        User user2 = new User("abc2",21);
        User user3 = new User("abc3",22);
        User user4 = new User("abc4",20);
        User user5 = new User("abc5",24);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        DBManager.getInstance(this).saveUsers(list);
    }

    private void getAll(){
        List<User> users = DBManager.getInstance(this).queryUser();
        for(User user : users){
            Log.i("MainActivity","name:"+user.getName());
        }
    }

    private void get(){
        List<User> users = DBManager.getInstance(this).queryUser(20);
        for(User user : users){
            Log.i("MainActivity","name:"+user.getName());
        }
    }
}
