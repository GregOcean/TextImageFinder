package com.example.textimagefinder;

import android.graphics.Bitmap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private EditText editText;
    private ImageView imageView;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


}