package com.comp4310.doctorondemand;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorDetailActivity extends AppCompatActivity {

    ImageView profilePicImg;
    TextView nameTxt;
    TextView specializationTxt;
    TextView ratingTxt;
    TextView phoneTxt;
    TextView emailTxt;
    TextView ageTxt;
    TextView experienceTxt;
    Button copyEmailBtn;
    Button copyPhoneBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        profilePicImg = findViewById(R.id.profilePic);
        nameTxt = findViewById(R.id.nameTxt);
        specializationTxt = findViewById(R.id.specializationTxt);
        ratingTxt = findViewById(R.id.ratingTxt);
        phoneTxt = findViewById(R.id.phoneTxt);
        emailTxt = findViewById(R.id.emailTxt);
        ageTxt = findViewById(R.id.ageTxt);
        experienceTxt = findViewById(R.id.experienceTxt);
        copyEmailBtn = findViewById(R.id.copyEmailBtn);
        copyPhoneBtn = findViewById(R.id.copyPhoneBtn);
        backBtn = findViewById(R.id.backBtn);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nameTxt.setText(extras.getString("name"));
            specializationTxt.setText(extras.getString("specialization"));
            ratingTxt.setText("Rating: " + extras.getInt("rating") + "/5");
            phoneTxt.setText("Contact: " + extras.getString("phone"));
            emailTxt.setText("Email: " + extras.getString("email"));
            profilePicImg.setImageResource(extras.getInt("profilePic"));
            ageTxt.setText("Age: " + extras.getInt("age"));
            experienceTxt.setText("Experience: " + extras.getInt("experience") + " years");
        }

        copyEmailBtn.setOnClickListener(view -> {
            String email = "doctor@example.com";
            copyToClipboard("Email", email);
        });

        copyPhoneBtn.setOnClickListener(view -> {
            String phoneNumber = extras != null ? extras.getString("phone") : "";
            copyToClipboard("Phone Number", phoneNumber);
        });

        backBtn.setOnClickListener(view -> {
            finish();
        });
    }

    private void copyToClipboard(String label, String text) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, text);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, label + " copied to clipboard", Toast.LENGTH_SHORT).show();
    }
}
