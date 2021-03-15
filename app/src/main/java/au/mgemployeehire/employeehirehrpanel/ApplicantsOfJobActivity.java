package au.mgemployeehire.employeehirehrpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ApplicantsOfJobActivity extends AppCompatActivity {

    private TextView keyTextView;
    private ListView applicantEmailListView;
    private ContactEmailAdapter contactEmailAdapter;
    private List<JobApplyRecords> jobApplyRecordsList;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicants_of_job);

        keyTextView = findViewById(R.id.keyTVID);
        //emailTextView = findViewById(R.id.emailTextViewID);

        keyTextView.setText(AppConstant.keyStr);
        //String key = keyTextView.getText().toString();

        applicantEmailListView = findViewById(R.id.applicantEmailLVID);

        reference = FirebaseDatabase.getInstance().getReference().child("jobApplyRecords").child(AppConstant.keyStr);
        jobApplyRecordsList = new ArrayList<>();
        contactEmailAdapter = new ContactEmailAdapter(ApplicantsOfJobActivity.this,jobApplyRecordsList);

        applicantEmailListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Position:"+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ApplicantsOfJobActivity.this, ApplicantAcceptRejectActivity.class);

                TextView applicantName = (TextView) view.findViewById(R.id.name);
                TextView applicantEmail = (TextView) view.findViewById(R.id.email);
                TextView applicantContactEmail = (TextView) view.findViewById(R.id.contactEmail);
                TextView applicantContactNumber = (TextView) view.findViewById(R.id.contact);
                TextView applicantEducation = (TextView) view.findViewById(R.id.educationalQualification);
                TextView applicantExperience = (TextView) view.findViewById(R.id.experience);
                TextView applicantLicense = (TextView) view.findViewById(R.id.license);
                TextView applicantAvailability = (TextView) view.findViewById(R.id.availability);
                TextView encryptEmail = (TextView) view.findViewById(R.id.encryptedEmail);

                String applicantNameStr = applicantName.getText().toString();
                String applicantEmailStr = applicantEmail.getText().toString();
                String applicantContactEmailStr = applicantContactEmail.getText().toString();
                String applicantContactNumberStr = applicantContactNumber.getText().toString();
                String applicantEducationStr = applicantEducation.getText().toString();
                String applicantExperienceStr = applicantExperience.getText().toString();
                String applicantLicenseStr = applicantLicense.getText().toString();
                String applicantAvailabilityStr = applicantAvailability.getText().toString();
                String encryptEmailStr = encryptEmail.getText().toString();

                intent.putExtra("applicantName",applicantNameStr);
                intent.putExtra("applicantEmail", applicantEmailStr);//app sign in email
                intent.putExtra("applicantContactEmail",applicantContactEmailStr);//contact email
                intent.putExtra("applicantContactNumber",applicantContactNumberStr);
                intent.putExtra("applicantEducation",applicantEducationStr);
                intent.putExtra("applicantExperience",applicantExperienceStr);
                intent.putExtra("applicantLicense",applicantLicenseStr);
                intent.putExtra("applicantAvailability",applicantAvailabilityStr);
                intent.putExtra("encryptEmail", encryptEmailStr);


                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                jobApplyRecordsList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    JobApplyRecords jobApplyRecords = dataSnapshot.getValue(JobApplyRecords.class);
                    jobApplyRecordsList.add(jobApplyRecords);
                }
                applicantEmailListView.setAdapter(contactEmailAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}