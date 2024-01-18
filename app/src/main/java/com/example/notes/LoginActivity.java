package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    Button loginAccountBtn;
    ProgressBar progressBar;
    TextView createAccountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginAccountBtn = findViewById(R.id.login_account_btn);
        progressBar = findViewById(R.id.progress_bar);
        createAccountTextView = findViewById(R.id.create_account_btn);

        loginAccountBtn.setOnClickListener(v -> loginUser());
        createAccountTextView.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class)));
    }

    public void loginUser() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean isValidInput = validatePassword(email, password);
        if (!isValidInput) {
            return;
        }
        loginUserInFirebase(email, password);
    }

    private boolean validatePassword(String email, String password) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Email is required");
            return false;
        }
        return true; // Return true when the email is valid
    }

    public void loginUserInFirebase(String email, String password) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        changeInProgress(true);
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                changeInProgress(false);
                if (task.isSuccessful()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish(); // Optional: Finish the current activity
                } else {
                    Utility.showToast(LoginActivity.this, "Email Not Verified please verify your email");
                }
//                else {
//                    Utility.showToast(LoginActivity.this, task.getException().getLocalizedMessage());
//                }
            }
        });
    }

    public void changeInProgress(boolean inProgress) {
        if (inProgress) {
            progressBar.setVisibility(View.VISIBLE);
            loginAccountBtn.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            loginAccountBtn.setVisibility(View.VISIBLE);
        }
    }
}
