package au.mgemployeehire.employeehirehrpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Queue;

public class SearchDataActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private ListView searchDataListView;
    private AutoCompleteTextView textSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        //id declaration
        searchDataListView = findViewById(R.id.searchDataListViewID);
        textSearch = findViewById(R.id.textSearchID);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("applicantDetails");

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                populateSearch(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        databaseReference.addListenerForSingleValueEvent(valueEventListener);
    }

    private void populateSearch(DataSnapshot snapshot) {
        ArrayList<String> phoneNumbers = new ArrayList<>();
        if (snapshot.exists()){
            for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                String phoneNumberStr = dataSnapshot.child("applicantContactNumber").getValue(String.class);
                phoneNumbers.add(phoneNumberStr);
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, phoneNumbers);
            textSearch.setAdapter(adapter);
            textSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String phoneNumber = textSearch.getText().toString();
                    SearchApplicant(phoneNumber);
                }
            });

        }else {
            Log.d("applicant", "No data found");
        }
    }

    private void SearchApplicant(String phoneNumber) {
        Query query = databaseReference.orderByChild("applicantContactNumber").equalTo(phoneNumber);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    ArrayList<String> listApplicants = new ArrayList<>();
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        ApplicantDetails applicantDetails = new ApplicantDetails(
                                dataSnapshot.child("applicantName").getValue(String.class),
                                dataSnapshot.child("applicantContactNumber").getValue(String.class),
                                dataSnapshot.child("applicantEmail").getValue(String.class),
                                dataSnapshot.child("applicantEducationalQualification").getValue(String.class),
                                dataSnapshot.child("applicantExperience").getValue(String.class),
                                dataSnapshot.child("applicantLicense").getValue(String.class),
                                dataSnapshot.child("applicantAvailability").getValue(String.class)
                                );

                        listApplicants.add(applicantDetails.getApplicantName()+"\n"+ applicantDetails.getApplicantContactNumber()+"\n"+
                                applicantDetails.getApplicantEmail()+"\n"+applicantDetails.getApplicantEducationalQualification()+"\n"+
                                applicantDetails.getApplicantExperience()+"\n"+applicantDetails.getApplicantLicense()+"\n"+
                                applicantDetails.getApplicantAvailability());
                    }
                    ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, listApplicants);
                    searchDataListView.setAdapter(adapter);

                }else {
                    Log.d("applicantDetails", "No data found");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}