package au.mgemployeehire.employeehirehrpanel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactEmailAdapter extends ArrayAdapter<JobApplyRecords> {

    private Activity context;
    private List<JobApplyRecords> emailList;

    public ContactEmailAdapter(Activity context, List<JobApplyRecords> emailList) {
        super(context, R.layout.applicant_email_layout, emailList);
        this.context = context;
        this.emailList = emailList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.applicant_email_layout, null, true);

        JobApplyRecords records = emailList.get(position);

        TextView applicantName = view.findViewById(R.id.name);
        TextView emailTextView = view.findViewById(R.id.email);//sign in email
        TextView contactEmailTextView = view.findViewById(R.id.contactEmail);
        TextView contactNumberTextView = view.findViewById(R.id.contact);
        TextView experience = view.findViewById(R.id.experience);
        TextView license = view.findViewById(R.id.license);

        applicantName.setText(records.getApplicantName());
        emailTextView.setText(records.getEmail());
        contactEmailTextView.setText(records.getApplicantContactEmail());
        contactNumberTextView.setText(records.getApplicantContactNumber());
        experience.setText(records.getApplicantExperience());
        license.setText(records.getApplicantLicense());

        return view;
    }
}
