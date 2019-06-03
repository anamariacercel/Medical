package com.medical.models;

import java.util.List;

public class MedicalHistory {
    Long id;
    Treatment treatmentNames;
    private String disease;
    Boolean hadSurgery;

    public MedicalHistory(){};

    @Override
    public String toString() {
        return "MedicalHistory{" +
                "treatmentNames=" + treatmentNames +
                ", disease='" + disease + '\'' +
                ", hadSurgery=" + hadSurgery +
                '}';
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicalHistory(Long id, Treatment treatmentNames, String disease, Boolean hadSurgery) {
        this.treatmentNames = treatmentNames;
        this.hadSurgery = hadSurgery;
        this.disease=disease;
        this.id=id;
    }

    public Treatment getTreatmentNames() {
        return treatmentNames;
    }

    public void setTreatmentNames(Treatment treatmentNames) {
        this.treatmentNames = treatmentNames;
    }

    public Boolean getHadSurgery() {
        return hadSurgery;
    }

    public void setHadSurgery(Boolean hadSurgery) {
        this.hadSurgery = hadSurgery;
    }
}
