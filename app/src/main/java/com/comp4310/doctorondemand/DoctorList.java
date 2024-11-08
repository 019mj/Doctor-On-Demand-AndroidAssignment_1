package com.comp4310.doctorondemand;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DoctorList extends AppCompatActivity {
    private TextView cityNameTxt;
    private Spinner specializationSpn;
    private RadioGroup genderGroup;
    private ListView doctorListView;

    private Button filterBtn;
    private Button resetBtn;
    private Button backBtn;
    private final Doctor[] DOCTORS = DoctorGenerator.generateDoctors(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        cityNameTxt = findViewById(R.id.cityNameTxt);
        specializationSpn = findViewById(R.id.specializationSpn);
        genderGroup = findViewById(R.id.genderGroup);
        doctorListView = findViewById(R.id.doctorLst);
        filterBtn = findViewById(R.id.filterBtn);
        resetBtn = findViewById(R.id.resetBtn);
        backBtn = findViewById(R.id.backBtn);

        Intent intent = getIntent();
        String cityName = intent.getStringExtra("selectedCity");
        cityNameTxt.setText(cityName);

        String[] specializations = getResources().getStringArray(R.array.specializations);
        ArrayAdapter<String> specializationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, specializations);
        specializationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        specializationSpn.setAdapter(specializationAdapter);

        Doctor[] initialFilteredDoctors = filterDoctorsByCity(DOCTORS, cityName);
        updateDoctorListView(initialFilteredDoctors);

        filterBtn.setOnClickListener(v -> {
            String selectedSpecialization = specializationSpn.getSelectedItem().toString();
            char selectedGender = getSelectedGender();

            Doctor[] filteredDoctors = filterDoctors(DOCTORS, cityName, selectedSpecialization, selectedGender);
            updateDoctorListView(filteredDoctors);
        });

        resetBtn.setOnClickListener(v -> {
            Doctor[] cityDoctors = filterDoctorsByCity(DOCTORS, cityName);
            updateDoctorListView(cityDoctors);
        });

        doctorListView.setOnItemClickListener((parent, view, position, id) -> {
            Doctor selectedDoctor = (Doctor) parent.getItemAtPosition(position);

            Intent detailIntent = new Intent(DoctorList.this, DoctorDetailActivity.class);
            detailIntent.putExtra("name", selectedDoctor.getName());
            detailIntent.putExtra("specialization", selectedDoctor.getSpecialization());
            detailIntent.putExtra("rating", selectedDoctor.getRating());
            detailIntent.putExtra("phone", selectedDoctor.getContactNumber());
            detailIntent.putExtra("profilePic", selectedDoctor.getProfilePic());
            detailIntent.putExtra("age", selectedDoctor.getAge());
            detailIntent.putExtra("experience", selectedDoctor.getExperience());
            detailIntent.putExtra("email", selectedDoctor.getEmail());
            startActivity(detailIntent);
        });

        backBtn.setOnClickListener(view -> {
            finish();
        });


    }

    private void updateDoctorListView(Doctor[] doctors) {
        ArrayAdapter<Doctor> doctorAdapter = new ArrayAdapter<>(this, R.layout.list_item, doctors);
        doctorListView.setAdapter(doctorAdapter);
    }

    private char getSelectedGender() {
        int selectedGenderId = genderGroup.getCheckedRadioButtonId();
        if (selectedGenderId == R.id.maleRadio) {
            return 'M';
        } else if (selectedGenderId == R.id.femaleRadio) {
            return 'F';
        }
        return 'A';
    }

    private static Doctor[] filterDoctorsByCity(Doctor[] doctors, String city) {
        ArrayList<Doctor> doctorArrayList = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getCity().equals(city)) {
                doctorArrayList.add(doctor);
            }
        }
        return doctorArrayList.toArray(new Doctor[0]);
    }

    private static Doctor[] filterDoctors(Doctor[] doctors, String city, String specialization, char gender) {
        ArrayList<Doctor> doctorArrayList = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getCity().equals(city) && (specialization.equals("Any") || doctor.getSpecialization().equals(specialization)) && (gender == 'A' || doctor.getGender() == gender)) {
                doctorArrayList.add(doctor);
            }
        }
        return doctorArrayList.toArray(new Doctor[0]);
    }
}
