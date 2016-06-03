package org.sourceit.util;

import org.sourceit.command.ICommand;
import org.sourceit.command.impl.applicant.*;/*
import org.sourceit.command.impl.applicantresult.*;
import org.sourceit.command.impl.profession.*;
import org.sourceit.command.impl.specialitysubject.*;
import org.sourceit.command.impl.subject.*;*/
import org.sourceit.command.impl.profession.*;

import java.util.HashMap;
import java.util.Map;

public enum Chooser {

    INSTANCE;

    private Map<String, ICommand> commandMap = new HashMap<>();

    Chooser() {

        // commands for profession
       commandMap.put("professions", new ProfessionCommand());
        commandMap.put("addProfession", new AddProfessionCommand());
        commandMap.put("saveProfession", new SaveProfessionCommand());
        commandMap.put("deleteProfession", new DeleteProfessionCommand());
        commandMap.put("editProfession", new EditProfessionCommand());

        // commands for applicants
        commandMap.put("applicants", new ApplicantCommand());
        commandMap.put("addApplicant", new AddApplicantCommand());
        commandMap.put("saveApplicant", new SaveApplicantCommand());
        commandMap.put("deleteApplicant", new DeleteApplicantCommand());
        commandMap.put("editApplicant", new EditApplicantCommand());
/*
       /* // commands for subjects
        commandMap.put("subjects", new SubjectCommand());
        commandMap.put("addSubject", new AddSubjectCommand());
        commandMap.put("saveSubject", new SaveSubjectCommand());
        commandMap.put("deleteSubject", new DeleteSubjectCommand());
        commandMap.put("editSubject", new EditSubjectCommand());

        // commands for speciality subjects
        commandMap.put("specSubjects", new SpecialitySubjectCommand());
        commandMap.put("addSpecSubject", new AddSpecialitySubjectCommand());
        commandMap.put("saveSpecSubject", new SaveSpecialitySubjectCommand());
        commandMap.put("deleteSpecSubject", new DeleteSpecialitySubjectCommand());
        commandMap.put("editSpecSubject", new EditSpecialitySubjectCommand());

        // commands for applicant results
        commandMap.put("applicantResults", new ApplicantResultCommand());
        commandMap.put("addApplicantResult", new AddApplicantResultCommand());
        commandMap.put("saveApplicantResult", new SaveApplicantResultCommand());
        commandMap.put("deleteApplicantResult", new DeleteApplicantResultCommand());
        commandMap.put("editApplicantResult", new EditApplicantResultCommand());
*/
    }

    public ICommand chooseCommand(String command) {
        return commandMap.get(command);
    }

}
