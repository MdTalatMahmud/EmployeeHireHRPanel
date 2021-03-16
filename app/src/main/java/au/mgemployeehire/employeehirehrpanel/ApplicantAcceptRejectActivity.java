package au.mgemployeehire.employeehirehrpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ApplicantAcceptRejectActivity extends AppCompatActivity {

    private TextView advertisementIDTextView, acceptRejectTextView;
    private TextView applicantNameTextView, applicantEmailTextView, applicantContactEmailTextView, applicantContactNumberTextView,
            applicantEducationTextView, applicantExperienceTextView, applicantLicenseTextView, applicantAvailabilityTextView, encryptEmailTextView;
    private Button rejectButton, acceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_accept_reject);

        advertisementIDTextView = findViewById(R.id.advertisementID);

        applicantNameTextView = findViewById(R.id.applicantNameTVID);
        applicantEmailTextView = findViewById(R.id.applicantEmailTVID);
        applicantContactEmailTextView = findViewById(R.id.applicantContactEmailTVID);
        applicantContactNumberTextView = findViewById(R.id.applicantContactNumberTVID);
        applicantEducationTextView = findViewById(R.id.applicantEducationTVID);
        applicantExperienceTextView = findViewById(R.id.applicantExperienceTVID);
        applicantLicenseTextView = findViewById(R.id.applicantLicenseTVID);
        applicantAvailabilityTextView = findViewById(R.id.applicantAvailabilityTVID);
        encryptEmailTextView = findViewById(R.id.encryptEmailID);
        acceptRejectTextView = findViewById(R.id.acceptRejectTVID);

        rejectButton = findViewById(R.id.rejectBtnID);
        acceptButton = findViewById(R.id.acceptBtnID);

        advertisementIDTextView.setText(AppConstant.keyStr);

        //getting data
        Bundle applicantName = getIntent().getExtras();
        if (applicantName!=null){
            String applicantNameString = applicantName.getString("applicantName");
            applicantNameTextView.setText(applicantNameString);
        }

        Bundle applicantEmail = getIntent().getExtras();
        if (applicantEmail!=null){
            String applicantEmailString = applicantEmail.getString("applicantEmail");//app sign in email
            applicantEmailTextView.setText(applicantEmailString);
        }

        Bundle applicantContactEmail = getIntent().getExtras();
        if (applicantContactEmail!=null){
            String applicantContactEmailString = applicantContactEmail.getString("applicantContactEmail");
            applicantContactEmailTextView.setText(applicantContactEmailString);
        }

        Bundle applicantContactNumber = getIntent().getExtras();
        if (applicantContactNumber!=null){
            String applicantContactNumberStr = applicantContactNumber.getString("applicantContactNumber");
            applicantContactNumberTextView.setText(applicantContactNumberStr);
        }

        Bundle applicantEducation = getIntent().getExtras();
        if (applicantEducation!=null){
            String applicantEducationStr = applicantEducation.getString("applicantEducation");
            applicantEducationTextView.setText(applicantEducationStr);
        }

        Bundle applicantExperience = getIntent().getExtras();
        if (applicantExperience!=null){
            String applicantExperienceStr = applicantExperience.getString("applicantExperience");
            applicantExperienceTextView.setText(applicantExperienceStr);
        }

        Bundle applicantLicense = getIntent().getExtras();
        if (applicantLicense!=null){
            String applicantLicenseStr = applicantLicense.getString("applicantLicense");
            applicantLicenseTextView.setText(applicantLicenseStr);
        }

        Bundle applicantAvailability = getIntent().getExtras();
        if (applicantAvailability!=null){
            String applicantAvailabilityStr = applicantAvailability.getString("applicantAvailability");
            applicantAvailabilityTextView.setText(applicantAvailabilityStr);
        }

        Bundle emailEncrypt = getIntent().getExtras();
        if (emailEncrypt!=null){
            String emailEncryptStr = emailEncrypt.getString("encryptEmail");
            encryptEmailTextView.setText(emailEncryptStr);
        }

        //button functioning
        rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ApplicantAcceptRejectActivity.this,"Applicant Rejected", Toast.LENGTH_LONG).show();
                //acceptRejectTextView.setText("Candidate Rejected");
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("rejectedEmployees");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //rejected name list added to database
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantName").setValue(applicantNameTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("email").setValue(applicantEmailTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantContactEmail").setValue(applicantContactEmailTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantContactNumber").setValue(applicantContactNumberTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantEducationalQualification").setValue(applicantEducationTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantExperience").setValue(applicantExperienceTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantLicense").setValue(applicantLicenseTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantAvailability").setValue(applicantAvailabilityTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("encryptedEmailID").setValue(encryptEmailTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("acceptOrReject").setValue("Candidate Rejected");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                ApplicantAcceptRejectActivity.super.onBackPressed();

            }
        });

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ApplicantAcceptRejectActivity.this,"Applicant Accepted", Toast.LENGTH_LONG).show();
                //acceptRejectTextView.setText("Candidate Accepted");
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("acceptedEmployees");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //accepted name list added to database
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantName").setValue(applicantNameTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("email").setValue(applicantEmailTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantContactEmail").setValue(applicantContactEmailTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantContactNumber").setValue(applicantContactNumberTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantEducationalQualification").setValue(applicantEducationTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantExperience").setValue(applicantExperienceTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantLicense").setValue(applicantLicenseTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("applicantAvailability").setValue(applicantAvailabilityTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("encryptedEmailID").setValue(encryptEmailTextView.getText().toString());
                        databaseReference.child(advertisementIDTextView.getText().toString()).child(encryptEmailTextView.getText().toString()).child("acceptOrReject").setValue("Candidate Accepted");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                ApplicantAcceptRejectActivity.super.onBackPressed();
            }
        });
    }
}