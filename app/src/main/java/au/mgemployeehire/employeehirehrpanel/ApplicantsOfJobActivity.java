package au.mgemployeehire.employeehirehrpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ApplicantsOfJobActivity extends AppCompatActivity {

    private TextView keyTextView, emailTextView;
    private ListView applicantEmailListView;
    private ContactEmailAdapter contactEmailAdapter;
    private List<JobApplyRecords> jobApplyRecordsList;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicants_of_job);

        keyTextView = findViewById(R.id.keyTVID);
        emailTextView = findViewById(R.id.emailTextViewID);

        keyTextView.setText(AppConstant.keyStr);
        //String key = keyTextView.getText().toString();

        applicantEmailListView = findViewById(R.id.applicantEmailLVID);

        reference = FirebaseDatabase.getInstance().getReference().child("jobApplyRecords").child(AppConstant.keyStr);
        jobApplyRecordsList = new ArrayList<>();
        contactEmailAdapter = new ContactEmailAdapter(ApplicantsOfJobActivity.this,jobApplyRecordsList);



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