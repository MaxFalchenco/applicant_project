//package org.sourceit.command.impl.subjects;
//
//import org.sourceit.command.ICommand;
//import org.sourceit.db.SubjectDBProvider;
//import org.sourceit.entities.Subject;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class SaveSubjectCommand implements ICommand {
//    private SubjectDBProvider provider = SubjectDBProvider.INSTANCE;
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse resp) {
//        Subject subject = new Subject();
//        subject.setSubjectName(request.getParameter("subject_name"));
//        if (request.getParameter("subject_id") != null) {
//            subject.setId(Long.parseLong(request.getParameter("subject_id")));
//        }
//        try {
//            provider.saveSubject(subject);
//        } catch (Exception e) {
//            request.setAttribute("error", e);
//            return "pages/error.jsp";
//        }
//        return "controller?command=subjects";
//    }
//}