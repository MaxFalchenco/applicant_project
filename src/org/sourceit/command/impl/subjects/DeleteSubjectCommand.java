//package org.sourceit.command.impl.subjects;
//
//import org.sourceit.command.ICommand;
//import org.sourceit.db.SubjectDBProvider;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class DeleteSubjectCommand implements ICommand {
//    private SubjectDBProvider provider = SubjectDBProvider.INSTANCE;
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse resp) {
//        try {
//            Long subjectId = Long.parseLong(request.getParameter("id"));
//            provider.deleteSubject(subjectId);
//        } catch (Exception e) {
//            request.setAttribute("error", e);
//            return "pages/error.jsp";
//        }
//        return "controller?command=subjects";
//    }
//}