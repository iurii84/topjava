package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class UserAuthServlet extends HttpServlet {
    private static final Logger log = getLogger(UserAuthServlet.class);
    private InMemoryUserRepositoryImpl repository = new InMemoryUserRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("UserAuthServlet - doPost");
        Integer id = getId(req);
        req.setAttribute("userId", id);

        resp.sendRedirect("meals");


        id = null;
        //req.getRequestDispatcher("/meals").forward(req, resp);

    }

    private Integer getId(HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        log.info(email);

        User user = repository.getByEmail(email);
        Integer userID = user.getId();
        user = null;
        log.info("UserID = " + userID.toString());

        return userID;

    }
}
