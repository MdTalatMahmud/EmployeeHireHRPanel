package au.mgemployeehire.employeehirehrpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ExpressInquirySubMenuActivity extends AppCompatActivity {

    private Button accountInquiryButton, rosterInquiryButton, holidayInquiryButton, sickLeaveInquiryButton,
            cOVIDAssistanceButton, staffPPEButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_inquiry_sub_menu);

        accountInquiryButton = findViewById(R.id.accountInquiryButtonID);
        rosterInquiryButton = findViewById(R.id.rosterInquiryButtonID);
        holidayInquiryButton = findViewById(R.id.holidayInquiryButtonID);
        sickLeaveInquiryButton = findViewById(R.id.sickLeaveInquiryButtonID);
        cOVIDAssistanceButton = findViewById(R.id.cOVIDAssistanceButtonID);
        staffPPEButton = findViewById(R.id.staffPPEButtonID);


    }
}