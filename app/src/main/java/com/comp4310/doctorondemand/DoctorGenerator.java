package com.comp4310.doctorondemand;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DoctorGenerator {

    private static final String[] NAMES = {
            "Ahmad Al-Masri", "Layla Al-Qassem",
            "Salah Abu Samra", "Hanan Al-Khatib",
            "Omar Al-Haj", "Nada Abu Khalil",
            "Hussein Al-Mughni", "Sara Abu Laila",
            "Mohammed Al-Bakri", "Yasmin Al-Rashid",
            "Khaled Al-Quds", "Fatima Abu Asad",
            "Fadi Al-Zein", "Rania Al-Najjar",
            "Alaa Al-Saleh", "Reem Abu Zaid",
            "Samir Al-Hariri", "Nadia Al-Masry",
            "Ziad Al-Sabri", "Rasha Abu Samra",
            "Mustafa Al-Tamimi", "Lina Al-Hashimi",
            "Bassam Al-Jabari", "Rima Abu Omar",
            "Adel Al-Safadi", "Mona Al-Khouri",
            "Tariq Al-Jamal", "Maya Al-Khatib",
            "Hani Abu Rami", "Salma Al-Fayez",
            "Zayn Al-Kadi", "Shireen Abu Nasser",
            "Majed Al-Said", "Iman Al-Rawi",
            "Bilal Al-Hussein", "Amal Al-Zaher",
            "Rami Al-Din", "Laila Abu Nadir",
            "Saad Al-Ahmed", "Farah Abu Hasan",
            "Ayman Al-Munir", "Huda Al-Tariq",
            "Jamal Al-Salem", "Noor Al-Riyadh",
            "Maher Al-Adwan", "Samah Al-Amin",
            "Nasir Al-Muhaisen", "Roula Al-Hakim",
            "Samer Al-Bitar", "Hadeel Al-Sharif",
            "Nour Abu Laban", "Yara Al-Rasheed",
            "Qasim Al-Jundi", "Aya Al-Najjar",
            "Tamer Al-Hassan", "Dana Al-Azzam",
            "Fouad Al-Hijazi", "Mirna Abu Rabia",
            "Karim Al-Sheikh", "Suha Al-Maadi",
            "Wael Al-Sabbagh", "Lama Al-Daoud",
            "Jad Al-Khatib", "Heba Abu Azzam",
            "Marwan Al-Hajjar", "Rana Al-Samra",
            "Haitham Al-Karim", "Nisreen Al-Khalil",
            "Wissam Al-Khayyat", "Sahar Al-Mahdi",
            "Ibrahim Al-Sabbagh", "Manal Abu Jamal",
            "Salem Al-Jundi", "Lubna Al-Hariri",
            "Feras Al-Jabbari", "Maha Abu Salem",
            "Iyas Al-Qudsi", "Salwa Al-Saleh",
            "Kareem Al-Azzam", "Dina Al-Rifa'i",
            "Ahmad Al-Saadi", "Tala Al-Sabbagh",
            "Adham Al-Jaabari", "Suhaila Al-Khatib",
            "Khalil Al-Zeidan", "Jihan Al-Ajami",
            "Mahmoud Al-Qadi", "Ruba Al-Zein",
            "Tawfiq Al-Hasan", "Samar Al-Idrissi",
            "Hashem Al-Murad", "Lubna Abu Faris",
            "Bassel Al-Rahman", "Fatimah Al-Nashashibi",
            "Othman Al-Halabi", "Nawal Al-Jibril",
            "Waheed Al-Khaled", "Sumaya Al-Tamimi",
            "Rafik Al-Sabah", "Bushra Al-Zayed"
    };

    private static final String[] SPECIALIZATIONS = {
            "Cardiologist", "Dermatologist", "Pediatrician", "Orthopedic",
            "Neurologist", "Gynecologist", "Radiologist", "Oncologist",
            "Psychiatrist", "Ophthalmologist", "ENT Specialist", "General Surgeon"
    };

    private static final String[] CITIES = {
            "Gaza", "Rafah", "Khan Yunis", "Beit Lahia", "Deir al Balah",
            "Bani Suheila", "Beit Hanoun", "Abasan al-Kabira", "Az Zawayda",
            "Nuseirat Camp", "Nazla", "Al-Shati Camp"
    };

    private static final Random RANDOM = new Random();

    public static Doctor[] generateDoctors(int count) {
        List<String> namesList = new ArrayList<>(List.of(NAMES));

        Doctor[] doctorsArray = new Doctor[count];
        for (int i = 0; i < count; i++) {
            String name = namesList.get(i);
            int age = 28 + RANDOM.nextInt(25);

            char gender = (i % 2 == 0) ? 'M' : 'F';
            int profilePic;

            Log.d(name, name + " " + gender);
            if (gender == 'M') {
                profilePic = (i % 4 == 0) ? R.drawable.profilepic1 : (i % 4 == 1) ? R.drawable.profilepic2 : (i % 4 == 2) ? R.drawable.profilepic3 : R.drawable.profilepic4;
            } else {
                profilePic = (i % 4 == 0) ? R.drawable.profilepic5 : (i % 4 == 1) ? R.drawable.profilepic7 : (i % 4 == 2) ? R.drawable.profilepic7 : R.drawable.profilepic8;
            }

            String specialization = SPECIALIZATIONS[RANDOM.nextInt(SPECIALIZATIONS.length)];
            int experience = 1 + RANDOM.nextInt(30);
            int rating = (int)(4 + (RANDOM.nextDouble() * 2));
            String contactNumber = "059" + (1000000 + RANDOM.nextInt(9000000));
            String email = name.toLowerCase().replaceAll(" ", ".") + "@freegaza.com";
            String city = CITIES[RANDOM.nextInt(CITIES.length)];
            String id = String.valueOf(i + 1);

            doctorsArray[i] = new Doctor(name, age, profilePic, gender, specialization, experience, rating, contactNumber, email, city, id);
        }
        return doctorsArray;
    }
}
