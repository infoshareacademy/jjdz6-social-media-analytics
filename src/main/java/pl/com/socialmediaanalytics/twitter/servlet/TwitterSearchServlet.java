package pl.com.socialmediaanalytics.twitter.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tweet-search")

public class TwitterSearchServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String textParam = req.getParameter("text");
        PrintWriter writer = resp.getWriter();

        if (textParam == null || textParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

    }
}
