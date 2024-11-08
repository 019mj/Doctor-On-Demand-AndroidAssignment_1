package com.comp4310.doctorondemand;

import androidx.annotation.NonNull;

public class Doctor {
    private String id;
    private String name;
    private int age;
    private int profilePic;
    private char gender;

    private String specialization;
    private int experience;
    private int rating;

    private String contactNumber;
    private String email;
    private String city;

    public Doctor(String name, int age, int profilePic, char gender, String specialization, int experience, int rating, String contactNumber, String email, String city, String id) {
        this.name = name;
        this.age = age;
        this.profilePic = profilePic;
        this.gender = gender;
        this.specialization = specialization;
        this.experience = experience;
        this.rating = rating;
        this.contactNumber = contactNumber;
        this.email = email;
        this.city = city;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getProfilePic(){
        return this.profilePic;
    }

    public void setProfilePic(int profilePic){
        this.profilePic = profilePic;
    }

    public char getGender(){
        return this.gender;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static final Doctor[] doctors = DoctorGenerator.generateDoctors(100);

    @NonNull
    @Override
    public String toString() {
        return "Dr. " + name + ", Specialization: " + specialization + ", " + rating + "/5";
    }




}
