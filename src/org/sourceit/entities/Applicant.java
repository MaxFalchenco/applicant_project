package org.sourceit.entities;

import java.util.Locale;

public class Applicant extends Entity {

    private long professionId;
    private String lastName;
    private String firstName;
    private int entranceYear;

    public Applicant() {
        this.id = -1;
    }

    public Long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(long professionId) {
        this.professionId = professionId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }
}
