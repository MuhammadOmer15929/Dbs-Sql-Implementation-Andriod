package com.example.dbssql2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.os.strictmode.CredentialProtectedWhileLockedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    helper myDb;
    EditText txt1;
    EditText txt2;
    EditText txt3;
    EditText txt4;
    EditText txt5;
    EditText txt6;
    EditText txt7;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new helper(this);
        txt1 = (EditText) findViewById(R.id.editTextTextPersonName);
        txt2 = (EditText) findViewById(R.id.editTextTextEmailAddress);
        txt3 = (EditText) findViewById(R.id.editTextNumber);
        txt4 = (EditText) findViewById(R.id.editTextTextPersonName2);
        txt5 = (EditText) findViewById(R.id.editTextTextPersonName4);
        txt6 = (EditText) findViewById(R.id.editTextTextPersonName5);
        txt7 = (EditText) findViewById(R.id.editTextTextPersonName6);
        btn3 = (Button) findViewById(R.id.button);
        myDb = new helper(this);
        btn4 = (Button) findViewById(R.id.button4);
        btn1 = (Button) findViewById(R.id.button2);

        btn2 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean insertdata1 = myDb.insertdata(txt1.getText().toString(),
                        txt2.getText().toString(),
                        txt3.getText().toString(),
                        txt4.getText().toString(),
                        txt5.getText().toString(),
                        txt6.getText().toString(),
                        txt7.getText().toString());
                if (insertdata1 = true)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = myDb.showData();
                if (cursor.getCount() == 0) {

                    Toast.makeText(MainActivity.this, "Error, No Entries Found!", Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    buffer.append("REGNO" + cursor.getString(1) + "\n");
                    buffer.append("CNIC" + cursor.getString(2) + "\n");
                    buffer.append("NAME" + cursor.getString(3) + "\n");
                    buffer.append("FATHERNAME" + cursor.getString(5) + "\n");
                    buffer.append("SEMESTER" + cursor.getString(5) + "\n");
                    buffer.append("GPA" + cursor.getString(6) + "\n");
                    buffer.append("YEAR" + cursor.getString(7) + "\n");

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Data");
                builder.setMessage(buffer.toString());
                builder.show();
            }


        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, list.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean update1 = myDb.updateData(txt1.getText().toString(),
                        txt2.getText().toString(),
                        txt3.getText().toString(),
                        txt4.getText().toString(),
                        txt5.getText().toString(),
                        txt6.getText().toString(),
                        txt7.getText().toString());
                if (update1 = true)
                    Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_LONG).show();
            }


        });
    }
}