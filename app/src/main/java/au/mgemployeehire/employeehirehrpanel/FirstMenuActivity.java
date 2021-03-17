package au.mgemployeehire.employeehirehrpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstMenuActivity extends AppCompatActivity {

    private Button expressHR, expressInquiry, expressRoster, expressPayroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_menu);

        expressHR = findViewById(R.id.ExpressHRID);
        expressInquiry = findViewById(R.id.expressInquiryID);
        expressRoster = findViewById(R.id.expressRosterID);
        expressPayroll = findViewById(R.id.expressPayrollID);

        expressHR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, ExpressHRSubMenuActivity.class);
                startActivity(intent);
            }
        });

        expressInquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, ExpressInquirySubMenuActivity.class);
                startActivity(intent);
            }
        });

        expressRoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, ExpressRosterSubMenuActivity.class);
                startActivity(intent);
            }
        });

        expressPayroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, ExpressPayrollSubMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}