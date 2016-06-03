//package org.sourceit.command.impl.subjects;
//
//import org.sourceit.command.ICommand;
//import org.sourceit.db.SubjectDBProvider;
//import org.sourceit.entities.Subject;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//public class SubjectCommand implements ICommand {
//    private SubjectDBProvider provider = SubjectDBProvider.INSTANCE;
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse resp) {
//        List<Subject> subjects;
//        try {
//            subjects = provider.getSubjects();
//        } catch (Exception e) {
//            request.setAttribute("error", e);
//            return "pages/error.jsp";
//        }
//        request.setAttribute("subjects", subjects);
//        return "pages/applicant/subjects.jsp";
//    }
//}