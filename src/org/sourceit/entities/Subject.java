package org.sourceit.entities;

public class Subject extends Entity {

    private String subjectName;

    public Subject() {
        this.id = -1;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
