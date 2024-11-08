package com.comp4310.doctorondemand;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Spinner citiesSpn;
    private final Doctor[] DOCTORS = DoctorGenerator.generateDoctors(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        citiesSpn = findViewById(R.id.citiesSpn);
        String[] items = getResources().getStringArray(R.array.cities);

        ArrayAdapter<String> CitiesAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);

        citiesSpn.setAdapter(CitiesAdapter);

        Button goBtn = findViewById(R.id.goBtn);
        goBtn.setOnClickListener(v -> {
            String selectedCity = citiesSpn.getSelectedItem().toString();
            Intent intent = new Intent(MainActivity.this, DoctorList.class);
            intent.putExtra("selectedCity", selectedCity);
            startActivity(intent);
        });


    }
}