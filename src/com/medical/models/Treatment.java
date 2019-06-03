package com.medical.models;

import java.util.List;

public class Treatment {
    Long id;
    String nameofDisease;
    List<Pill> pills;
    int administrationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Treatment(Long id, String nameDisease, List<Pill> pill, int administrationTime) {
        this.id=id;
        this.nameofDisease = nameDisease;
        this.pills = pill;
        this.administrationTime = administrationTime;
    }

    public List<Pill> getPills() {
        return pills;
    }

    public void setPills(List<Pill> pills) {
        this.pills = pills;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "nameofDisease='" + nameofDisease + '\'' +
                ", pills=" + pills +
                ", administrationTime=" + administrationTime +
                '}';
    }

    public String getNameofDisease() {
        return nameofDisease;
    }

    public void setNameofDisease(String nameofDisease) {
        this.nameofDisease = nameofDisease;
    }

    public int getAdministrationTime() {
        return administrationTime;
    }

    public void setAdministrationTime(int administrationTime) {
        this.administrationTime = administrationTime;
    }
}
