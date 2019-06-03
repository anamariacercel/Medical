package com.medical.models;

public class Doctor implements Comparable<Doctor> {
    Long id;
    private String firstName;
    private String lastName;
    private String specialisation;
    private int levelTraining;
    private String universityName;

    public Doctor(){

    }

    public Doctor(Long id, String firstName, String lastName, String specialisation, int levelTraining, String universityName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialisation = specialisation;
        this.levelTraining = levelTraining;
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialisation='" + specialisation + '\'' +
                ", levelTraining='" + levelTraining + '\'' +
                ", universityName='" + universityName + '\'' +
                '}';
    }

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

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int getLevelTraining() {
        return levelTraining;
    }

    public void setLevelTraining(int levelTraining) {
        this.levelTraining = levelTraining;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public int compareTo(Doctor o) {
        if(this.getLevelTraining()<o.getLevelTraining())
            return 1;
        else
            return 0;
    }
}
