package com.medical.models;

import java.util.List;

public class PatientAdult extends Patient {
    private boolean hasSTD;
    public List<String> allergies;

    @Override
    public String toString() {
        return "PatientAdult{" +
                "hasSTD=" + hasSTD +
                ", allergies=" + allergies +
                ", id=" + id +
                '}';
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public boolean isHasSTD() {
        return hasSTD;
    }

    public void setHasSTD(boolean hasSTD) {
        this.hasSTD = hasSTD;
    }

    public PatientAdult(Long id, String firstName, String lastName, String email, String CNP, String bloodType, int age, String sex, PatientFile file, String allergy, boolean hasSTD) {
        super(id, firstName, lastName, email, CNP, bloodType, age, sex, file, allergy);
        this.hasSTD = hasSTD;

    }
    @Override
    public boolean hasAllergies() {
        if(allergies.contains(this.getAllergy()))
            return true;
        else
            return false;
    }
}
