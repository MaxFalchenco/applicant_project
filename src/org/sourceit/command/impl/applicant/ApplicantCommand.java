package org.sourceit.command.impl.applicant;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ApplicantCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        List<Applicant> applicants;
        try {
            applicants = provider.getApplicants();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }
        request.setAttribute("applicants", applicants);

        return "pages/applicant/applicants.jsp";
    }
}