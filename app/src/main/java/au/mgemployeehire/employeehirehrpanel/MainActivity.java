package au.mgemployeehire.employeehirehrpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button showAllJobPostButton, acceptedEmployeesButton, rejectedEmployeesButton, searchEmployeesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding id
        showAllJobPostButton = findViewById(R.id.showAllJobPostBtnID);
        acceptedEmployeesButton = findViewById(R.id.acceptedEmployeesBtnID);
        rejectedEmployeesButton = findViewById(R.id.rejectedEmployeesBtnID);
        searchEmployeesButton = findViewById(R.id.searchEmployeesBtnID);

        //button functioning
        showAllJobPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JobPositionSelectionActivity.class);
                startActivity(intent);
            }
        });

        acceptedEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
            }
        });

        rejectedEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
            }
        });

        searchEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchDataActivity.class);
                startActivity(intent);
            }
        });
    }

    //menu adding
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.userSignOutMenuID){
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}