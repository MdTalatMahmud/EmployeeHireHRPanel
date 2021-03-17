package au.mgemployeehire.employeehirehrpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText signUpEmailEditText, signUpPasswordEditText, companyNameEditText, companyContactNumberEditText, companyEmailEditText, companySuburbEditText, companyStreetEditText, CompanyStateEditText;
    private TextView gotoSignInTextView;
    private Button signUpButton;
    private ProgressBar progressBarSignUp;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        //finding id
        signUpEmailEditText = findViewById(R.id.signupEmailID);
        signUpPasswordEditText = findViewById(R.id.signupPasswordID);

        gotoSignInTextView = findViewById(R.id.gotoSignInTVID);
        signUpButton = findViewById(R.id.signupBtnID);
        progressBarSignUp = findViewById(R.id.signinProgressBarID);

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        signUpButton.setOnClickListener(this);
        gotoSignInTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signupBtnID:
                userRegister();
                break;

            case R.id.gotoSignInTVID:
                Intent intent = new Intent(getApplicationContext(),SigninActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userRegister() {
        String email = signUpEmailEditText.getText().toString().trim();
        String password = signUpPasswordEditText.getText().toString().trim();

        if (email.isEmpty()){
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            signUpEmailEditText.setError("Enter a valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        if (password.isEmpty()){
            signUpPasswordEditText.setError("Enter an email address");
            signUpPasswordEditText.requestFocus();
            return;
        }
        if (password.length()<6){
            signUpPasswordEditText.setError("Password should be at least 6 characters");
            signUpPasswordEditText.requestFocus();
            return;
        }
        //showing progress bar
        progressBarSignUp.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBarSignUp.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(getApplicationContext(), "Register Successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, FirstMenuActivity.class);
                    startActivity(intent);
                } else {
                    // If sign in fails, display a message to the user.
                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "User email already registered",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Oops! Something wrong. Please, try again later",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

}