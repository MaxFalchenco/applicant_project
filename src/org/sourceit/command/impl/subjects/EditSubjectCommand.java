//package org.sourceit.command.impl.subjects;
//
//import org.sourceit.command.ICommand;
//import org.sourceit.db.SubjectDBProvider;
//import org.sourceit.entities.Subject;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class EditSubjectCommand implements ICommand {
//
//    private SubjectDBProvider provider = SubjectDBProvider.INSTANCE;
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse resp) {
//        try {
//            Long subjectId = Long.parseLong(request.getParameter("id"));
//            Subject subject = provider.getSubject(subjectId);
//            request.setAttribute("subject", subject);
//        } catch (Exception e) {
//            request.setAttribute("error", e);
//            return "pages/error.jsp";
//        }
//
//        request.setAttribute("title", "Edit Subject");
//        return "pages/applicant/edit_subject.jsp";
//    }
//}