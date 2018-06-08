package com.android.order_ser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by anand on 5/18/2018.
 */

public class RegisterActivity extends AppCompatActivity {
  EditText email,password,passwordrepeat;
    Button register;
    FirebaseAuth auth;
    DatabaseReference database;
    DatabaseReference database2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newregister);
        database = FirebaseDatabase.getInstance().getReference().getRoot();
        database2 = FirebaseDatabase.getInstance().getReference().getRoot();
        email =(EditText)findViewById(R.id.emailreg);
        password = (EditText)findViewById(R.id.passwordreg);
        passwordrepeat = (EditText)findViewById(R.id.passwordreg2);
        register = (Button)findViewById(R.id.button2);
        auth = FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emails = email.getText().toString();
                String passwords = password.getText().toString();
                auth.createUserWithEmailAndPassword(emails,passwords)
                        .addOnCompleteListener(RegisterActivity.this,new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "compleated " + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {


                                    Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });


    }

}