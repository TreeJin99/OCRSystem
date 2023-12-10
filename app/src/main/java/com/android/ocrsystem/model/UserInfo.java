package com.android.ocrsystem.model;

import java.util.List;

public class UserInfo {
    private String name;
    private List<Allergy> allergies;

    public UserInfo(String name, List<Allergy> allergies) {
        this.name = name;
        this.allergies = allergies;
    }

    public UserInfo() {
        this("", null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }
}
