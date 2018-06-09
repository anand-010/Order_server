package com.android.order_ser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class cookiecutter extends AppCompatActivity {
    public Bitmap bitmap,croppedimg;
    Button button;
     CropImageView cropImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookiecutter);
        button = (Button)findViewById(R.id.select);
        cropImageView = (CropImageView)findViewById(R.id.cropImageView);
        Bundle b =getIntent().getExtras();
        if (b!=null){
            Uri uri= (Uri) b.get("anands");
            /**
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                cropImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
             */
            cropImageView.setImageUriAsync(uri);
        }


button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        croppedimg = cropImageView.getCroppedImage();
        bitmaphelper bitmap = new  bitmaphelper();
        bitmap.setBitmap(croppedimg);

        /**
        String path = Environment.getExternalStorageDirectory().toString();
        OutputStream fOut = null;
        Integer counter = 0;
        int i = 0;
        File file = new File(path, String.valueOf(i)+"FitnessGirl.jpg"); // the File to save , append increasing numeric counter to prevent files from getting overwritten.
        i +=1;
        try {
            fOut = new FileOutputStream(file);
            croppedimg.compress(Bitmap.CompressFormat.JPEG, 85, fOut);
            fOut.flush(); // Not really required
            fOut.close();
            MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         */
        Intent data = new Intent();
        data.putExtra("anands","hallow");
        setResult(RESULT_OK, data);
        finish();

    }
});
    }
}
