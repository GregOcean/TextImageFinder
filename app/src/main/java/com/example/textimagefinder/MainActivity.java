package com.example.textimagefinder;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private EditText editText;
    private ImageView imageView;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PackageManager.PERMISSION_GRANTED);

        textView = findViewById(R.id.editTextTextPersonName);
        editText = findViewById(R.id.editTextTextPersonName2);
        imageView = findViewById(R.id.imageView);
    }

    public void buttonReadText(View view) {
        try {
            String stringFileName = "/sdcard/Download/" + editText.getText().toString();
            bitmap = BitmapFactory.decodeFile(stringFileName);

            imageView.setImageBitmap(bitmap);

            TextRecognizer textRecognizer = new TextRecognizer.Builder(this).build();

            Frame frameImage = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<TextBlock> textBlockSparseArray = textRecognizer.detect(frameImage);
            String stringImageText = "";
            for (int i=0; i < textBlockSparseArray.size(); i++){
                TextBlock textBlock = textBlockSparseArray.get(textBlockSparseArray.keyAt(i));
                stringImageText = stringImageText + "" + textBlock.getValue();
            }
            textView.setText(stringImageText);
        } catch (Exception e){
            textView.setText("Failed when Read Text");
        }

    }
}