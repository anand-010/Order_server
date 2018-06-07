package com.android.order_ser;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
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

/**
 * Created by anand on 5/19/2018.
 */

public class jkl extends AppCompatActivity {

    FirebaseAuth auth;
    EditText emailtext,passwordtext;
    Button login,register;
    String email,password;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlogin);
        auth = FirebaseAuth.getInstance();
        emailtext = (EditText)findViewById(R.id.n);
        passwordtext = (EditText)findViewById(R.id.pass);
        login =(Button)findViewById(R.id.button);
        register = (Button)findViewById(R.id.gotoregister);
if (auth.getCurrentUser()!=null){
    startActivity(new Intent(jkl.this, profile.class));
    finish();
}
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options =
                            ActivityOptions.makeSceneTransitionAnimation(jkl.this, register,"register");
                    startActivity(new Intent(jkl.this, RegisterActivity.class), options.toBundle());
                } else {
                    startActivity(new Intent(jkl.this, RegisterActivity.class));
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailtext.getText().toString();
                password = passwordtext.getText().toString();
                auth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(jkl.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(jkl.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(jkl.this, profile.class));
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}
