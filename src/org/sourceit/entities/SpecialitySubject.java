package org.sourceit.entities;

public class SpecialitySubject extends Entity {

    private Profession profession;
    private Subject subject;

    public SpecialitySubject() {
        this.id = -1;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
