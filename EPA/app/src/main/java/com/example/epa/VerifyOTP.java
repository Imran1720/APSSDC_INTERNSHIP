package com.example.epa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class VerifyOTP extends AppCompatActivity {
    EditText otp;
    ProgressBar progressBar;
    String verificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        otp= findViewById(R.id.otp);
        progressBar = findViewById(R.id.progressbar);
        verificationId = getIntent().getStringExtra("verificationId");
    }

    public void verify(View view) {

        if(otp.getText().toString().trim().isEmpty())
        {
            otp.setError("Enter OTP");
            return;
        }
        String code = otp.getText().toString();

        if(verificationId != null)
        {
            progressBar.setVisibility(View.VISIBLE);
            PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId,code);
            FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.setVisibility(View.GONE);
                    if(task.isSuccessful())
                    {
                        Intent i = new Intent(VerifyOTP.this,HomeActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    }
                    else {
                        otp.setError("Invalid OTP");
                    }
                }
            });
        }
    }
}