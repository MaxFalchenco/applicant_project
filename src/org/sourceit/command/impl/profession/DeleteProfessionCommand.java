package org.sourceit.command.impl.profession;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProfessionCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        try {
            Long professionId = Long.parseLong(request.getParameter("id"));
            provider.deleteProfession(professionId);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=professions";
    }
}