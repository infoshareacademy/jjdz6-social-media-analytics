package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.dto.UserDTO;
import pl.com.socialmediaanalytics.twitter.service.SearchUserService;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet("/search-user")
public class SearchUserServlet extends HttpServlet {
    @Inject
    TemplateProvider templateProvider;

    @Inject
    SearchUserService searchUserService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        List<UserDTO> statusList = searchUserService.userDTOList(user);
        Map<String, List<UserDTO>> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), "user.ftlh");

        model.put("users", statusList);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, List<String>> model = new HashMap<>();
        model.put("users", Collections.emptyList());
        Template template = templateProvider.getTemplate(getServletContext(), "user.ftlh");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
           e.printStackTrace();
        }
    }
}




