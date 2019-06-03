package com.medical.models;

public class Pill {
    Long id;
    private String name;
    private String prospect;

    @Override
    public String toString() {
        return "Pill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prospect='" + prospect + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProspect() {
        return prospect;
    }

    public void setProspect(String prospect) {
        this.prospect = prospect;
    }

    public Pill(Long id, String name, String prospect) {
        this.id = id;
        this.name = name;
        this.prospect = prospect;
    }
}
