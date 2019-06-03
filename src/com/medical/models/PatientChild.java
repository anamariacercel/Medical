package com.medical.models;

import java.util.List;

public class PatientChild extends Patient {
    private boolean orphan;
    public List<String> allergies;

    public PatientChild(Long id, String firstName, String lastName, String email, String CNP, String bloodType, int age, String sex, PatientFile file, String allergy, boolean orphan) {
        super(id, firstName, lastName, email, CNP, bloodType, age, sex, file, allergy);
        this.orphan = orphan;
        allergies.add("praf");
        allergies.add("fum");
    }

    @Override
    public String toString() {
        return "PatientChild{" +
                "orphan=" + orphan +
                ", allergies=" + allergies +
                ", id=" + id +
                '}';
    }

    public boolean isOrphan() {
        return orphan;
    }

    public void setOrphan(boolean orphan) {
        this.orphan = orphan;
    }

    public List<String> getAllergies() {
        return allergies;
    }


    @Override
    public boolean hasAllergies() {
        if(allergies.contains(this.getAllergy()))
            return true;
        else
            return false;
    }
}
