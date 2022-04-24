package com.example.dbssql2;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class list extends AppCompatActivity {
    helper myDb;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.listv);

        ListView listView=(ListView) findViewById(R.id.list);
        myDb =new helper(this);

        ArrayList<String> theList= new ArrayList<>();
        Cursor cursor =myDb.showData();

        if(cursor.getCount()==0)
        {
            Toast.makeText(list.this,"The DataBaseIsEmpty",Toast.LENGTH_LONG).show();}
        else
        {
            while (cursor.moveToNext())
            {
                theList.add(cursor.getString(1));
                theList.add(cursor.getString(2));
                theList.add(cursor.getString(3));
                theList.add(cursor.getString(4));
                theList.add(cursor.getString(5));
                theList.add(cursor.getString(6));
                theList.add(cursor.getString(7));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);



            }
        }


    }
}
