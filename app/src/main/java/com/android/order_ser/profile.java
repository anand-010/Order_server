package com.android.order_ser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by anand on 5/23/2018.
 */

public class profile extends AppCompatActivity {
    EditText name, age, place;
    Button propicset, coverfoto, next;
    DatabaseReference rootref;
    Map<String, Object> map = new HashMap<String, Object>();
    Uri filepath;
    CircleImageView circular;
    FirebaseStorage storage;
    StorageReference refferance;
    String url,url3;
    Uri imageUri;
    boolean on = false;
    Bitmap croppedimage;
    public Bitmap bitmap;
private final int PICK_IMAGE_REQUEST=72;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.newprofilecopy);
           rootref = FirebaseDatabase.getInstance().getReference().getRoot();
        name = (EditText) findViewById(R.id.storename);
        age = (EditText) findViewById(R.id.storephoneno);
        place = (EditText) findViewById(R.id.placeofstore);
        propicset = (Button) findViewById(R.id.button5);
        coverfoto = (Button) findViewById(R.id.button6);
        storage = FirebaseStorage.getInstance();
        refferance = storage.getReference();
        circular = (CircleImageView) findViewById(R.id.circularImageView2);

        rootref.child("server/users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Map<String, Object> map2 = (Map<String, Object>) dataSnapshot.getValue();
                    if (map2.containsKey("name")) {
                    name.setText(map2.get("name").toString()); }
                    if (map2.containsKey("age")) {
                    age.setText(map2.get("age").toString()); }
                    if (map2.containsKey("place")) {
                    place.setText(map2.get("place").toString()); }

                    if (map2.containsKey("profilepic")) {
                        url3 = map2.get("profilepic").toString();
                        Glide.with(profile.this)
                                .load(url3)
                                .into(circular);
                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(profile.this, "nasham", Toast.LENGTH_SHORT).show();
            }
        });
        coverfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (on==true) {
                    upload();
                }
                map.put("name", name.getText().toString());
                map.put("age", age.getText().toString());
                map.put("place", place.getText().toString());
                map.put("coverfoto", "httpskl");

                rootref.child("server/users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
overridePendingTransition(R.anim.slideleft,R.anim.slideleft);
                Intent intent = new Intent(profile.this,mainview.class);
                startActivity(intent);
            }
        });

        propicset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choseimage();
            }
        });
    }

    private void upload() {
            Toast.makeText(profile.this, "starting ", Toast.LENGTH_SHORT).show();
            StorageReference ref = refferance.child("server/images/profilepictures"+FirebaseAuth.getInstance().getCurrentUser().getUid());
            ref.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            url = taskSnapshot.getDownloadUrl().toString();
                            Toast.makeText(profile.this, "compleated", Toast.LENGTH_SHORT).show();
                            map.put("profilepic",url);
                            map.put("coverfoto", "httpskl");

                            rootref.child("server/users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
                        }
                    });
    }

    private void choseimage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            filepath = data.getData();
            on = true;
            bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(profile.this,cookiecutter.class);
            intent.putExtra("anands",filepath);
            startActivityForResult(intent,83);
            //circular.setImageBitmap(bitmap);
            Toast.makeText(profile.this, filepath.toString(), Toast.LENGTH_SHORT).show();

        }
        if (requestCode == 83 && resultCode == RESULT_OK){
            Bundle extras = getIntent().getExtras();
            String fileName = "1.jpg";
            int i = 0;
            String completePath = Environment.getExternalStorageDirectory() + "/" + String.valueOf(i)+"FitnessGirl.jpg";
            i +=1;
            Bitmap bitmap;
            bitmaphelper bitmaphelper = new bitmaphelper();
            bitmap = bitmaphelper.getBitmap();

            /**
            File file = new File(completePath);
            imageUri = Uri.fromFile(file);
            Glide.with(this)
                    .load(imageUri)
                    .into(circular);

            Toast.makeText(profile.this, "worked", Toast.LENGTH_SHORT).show();
             */
            circular.setImageBitmap(bitmap);
        }
    }
}