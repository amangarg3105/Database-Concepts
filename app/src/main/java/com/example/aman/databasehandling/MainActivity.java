package com.example.aman.databasehandling;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
    // final SharedPreferences sharedPreferences = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        final SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("userDB",MODE_PRIVATE,null);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Length",Toast.LENGTH_SHORT).show();
                // sharedPreferences.edit().putString("username","xyz").apply();
          /*  String username = sharedPreferences.getString("username","");
                Log.i("ButtonClicked",username);*/

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR)");

            sqLiteDatabase.execSQL("INSERT INTO users VALUES('abc')");
            sqLiteDatabase.execSQL("INSERT INTO users VALUES('xyz')");



                Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users",null);

                if(c != null) {
                   c.moveToFirst();
                    do {
                       int index = c.getColumnIndex("name");
                       String username = c.getString(index);
                       Log.d("username",username);
                   } while (c.moveToNext());
                }


            }
        });
    }
}
