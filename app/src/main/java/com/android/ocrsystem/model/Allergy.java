package com.android.ocrsystem.model;

public class Allergy {
    private String allergy;

    public Allergy(String allergy) {
        this.allergy = allergy;
    }

    public Allergy() {
        this("");
    }

    public Allergy toEnglish() {
        switch (this.allergy) {
            case "돼지고기":
                return new Allergy("pork");
            case "대두":
                return new Allergy("soybean");
            case "땅콩":
                return new Allergy("peanut");
            case "계란":
                return new Allergy("egg");
            case "우유":
                return new Allergy("milk");
            case "밀":
                return new Allergy("flour");
            case "복숭아":
                return new Allergy("peach");
            case "견과류":
                return new Allergy("nuts");
            case "갑각류":
                return new Allergy("crab");
            case "조개류":
                return new Allergy("clam");
            case "생선":
                return new Allergy("fish");
            default:
                return this;
        }
    }
}
