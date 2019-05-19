package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import pl.com.socialmediaanalytics.twitter.configuration.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.dao.UserRepositoryDao;
import pl.com.socialmediaanalytics.twitter.domain.User;
import pl.com.socialmediaanalytics.twitter.service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/tweet")
public class WelcomeUser extends HttpServlet {
    @Inject
    TemplateProvider templateProvider;
    @Inject
    UserService userService;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String age = req.getParameter("age");
        String city = req.getParameter("city");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        Integer agePars = Integer.parseInt(age);


        User user = new User();
        user.setName(name);
        user.setCity(city);
        user.setAge(agePars);
        user.setEmail(email);

        UserService userService = new UserService();
        userService.saveUser(user);
        resp.getWriter().println("User has been added");
        PrintWriter out = resp.getWriter();
        Map<String, String> model = new HashMap<>();
        model.put("name",email);
        Template template = templateProvider.getTemplate(getServletContext(), "main.ftlh");
        try {
            template.process(model, out);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

