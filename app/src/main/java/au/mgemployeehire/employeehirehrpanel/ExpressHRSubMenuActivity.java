package au.mgemployeehire.employeehirehrpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExpressHRSubMenuActivity extends AppCompatActivity {

    private Button viewApplicantDetailsButton, searchEmployeesButton, selectEmployeesButton, showRosterButton,
            showAvailabilityButton, showDropOffButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_h_r_sub_menu);

        viewApplicantDetailsButton = findViewById(R.id.viewApplicantDetailsButtonID);
        searchEmployeesButton = findViewById(R.id.searchEmployeesButtonID);
        selectEmployeesButton = findViewById(R.id.selectEmployeesButtonID);
        showRosterButton = findViewById(R.id.showRosterButtonID);
        showAvailabilityButton = findViewById(R.id.showAvailabilityButtonID);
        showDropOffButton = findViewById(R.id.showDropOffButtonID);

        //button functioning
        viewApplicantDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpressHRSubMenuActivity.this, JobPositionSelectionActivity.class);
                startActivity(intent);
            }
        });

        searchEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpressHRSubMenuActivity.this, SearchDataActivity.class);
                startActivity(intent);
            }
        });

        selectEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        showRosterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        showAvailabilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        showDropOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}