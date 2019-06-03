package com.medical.models;

import java.time.LocalDate;
import java.util.List;

public class PatientFile {
    Long id;
    LocalDate registeredDate;
    List<MedicalHistory> medicalHistory;
    String address;

    public PatientFile(){}

    @Override
    public String toString() {
        return "PatientFile{" +
                "registeredDate=" + registeredDate +
                ", medicalHistory=" + medicalHistory +
                ", address='" + address + '\'' +
                '}';
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public List<MedicalHistory> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<MedicalHistory> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientFile(Long id, LocalDate registeredDate, List<MedicalHistory> medicalHistory, String address) {
        this.registeredDate = registeredDate;
        this.medicalHistory = medicalHistory;
        this.address = address;
        this.id=id;
    }
}
