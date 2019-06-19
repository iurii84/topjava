package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepositoryImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class UserAuthServlet extends HttpServlet {
    private static final Logger log = getLogger(UserAuthServlet.class);
    private InMemoryUserRepositoryImpl repository = new InMemoryUserRepositoryImpl();
    private static Integer activeUser = 0;

    public static Integer getActiveUser() {
        return activeUser;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.debug("UserAuthServlet - doPost");


        activeUser = getId(req);

        resp.sendRedirect("meals");

    }

//    public static void setActiveUser(Integer activeUser) {
//        UserAuthServlet.activeUser = activeUser;
//    }

    private Integer getId(HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        log.info(email);

        User user = repository.getByEmail(email);
        Integer userID = user.getId();

        log.info("UserID = " + userID.toString());

        return userID;

    }
}
