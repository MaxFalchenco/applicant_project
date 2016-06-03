package org.sourceit.entities;

public class Profession extends Entity {

    public Profession() {
        this.id = -1;
    }

    public Profession(String professionName) {
        this();
        this.professionName = professionName;
    }

    private String professionName;

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "professionName='" + professionName + '\'' +
                '}';
    }
}
