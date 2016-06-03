//package org.sourceit.command.impl.subjects;
//
//import org.sourceit.command.ICommand;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class AddSubjectCommand implements ICommand {
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse resp) {
//        request.setAttribute("title", "Add Subject");
//
//        return "pages/applicant/edit_subject.jsp";
//    }
//}