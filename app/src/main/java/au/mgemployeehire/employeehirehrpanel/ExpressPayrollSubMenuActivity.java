package au.mgemployeehire.employeehirehrpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExpressPayrollSubMenuActivity extends AppCompatActivity {

    private Button paySlipButton, payInquiryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_payroll_sub_menu);

        paySlipButton = findViewById(R.id.paySlipButtonID);
        payInquiryButton = findViewById(R.id.payInquiryButtonID);

        paySlipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        payInquiryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}