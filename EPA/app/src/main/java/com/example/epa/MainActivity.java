package com.example.epa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText inputmobile;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputmobile = findViewById(R.id.phno);
        progressBar = findViewById(R.id.progressbar);
    }

    public void submit(View view) {

        if(inputmobile.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Enter mobile number", Toast.LENGTH_SHORT).show();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91"+inputmobile.getText().toString(),
                60,
                TimeUnit.SECONDS,
                MainActivity.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                    @Override
                    public void onCodeSent(@NonNull  String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        progressBar.setVisibility(View.GONE);
                        Intent i = new Intent(MainActivity.this,VerifyOTP.class);
                        i.putExtra("mobile",inputmobile.getText().toString());
                        i.putExtra("verificationId",s);
                        startActivity(i);
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
        );


    }
}