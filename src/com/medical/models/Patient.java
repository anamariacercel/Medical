package com.medical.models;

public abstract class Patient implements Comparable<Patient> {
    Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String CNP;
    private String bloodType;
    private int age;
    private String sex;
    private PatientFile file;
    private String allergy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", CNP='" + CNP + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +

                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Patient(Long id, String firstName, String lastName, String email, String CNP, String bloodType, int age, String sex, PatientFile file, String allergy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.CNP = CNP;
        this.bloodType = bloodType;
        this.age = age;
        this.sex = sex;
        this.file = file;
        this.allergy = allergy;
    }

    public abstract boolean hasAllergies();

    @Override
    public int compareTo(Patient o) {
        return this.getLastName().compareTo(o.getLastName());
    }

    public PatientFile getFile() {
        return file;
    }

    public void setFile(PatientFile file) {
        this.file = file;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
}
