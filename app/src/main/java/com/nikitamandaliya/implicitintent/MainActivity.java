package com.nikitamandaliya.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//https://www.youtube.com/watch?v=3lg_6R23JB4
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText field = findViewById(R.id.field);
        Button open = findViewById(R.id.open);

        //when button "open" was click
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);

                //prepare for web address
                intent.setData(Uri.parse(String.valueOf(field.getText())));

                //if there are any web browser available
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }

            }
        });

    }
}