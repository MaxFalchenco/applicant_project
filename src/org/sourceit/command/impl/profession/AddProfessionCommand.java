package org.sourceit.command.impl.profession;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProfessionCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        request.setAttribute("title", "Add profession");



        return "pages/profession/edit_profession.jsp";
    }
}
