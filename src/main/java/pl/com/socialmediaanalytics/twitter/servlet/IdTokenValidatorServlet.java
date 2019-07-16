package pl.com.socialmediaanalytics.twitter.servlet;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import pl.com.socialmediaanalytics.twitter.service.IdTokenValidatorService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class IdTokenValidatorServlet extends HttpServlet {


    @Inject
    IdTokenValidatorService idTokenValidatorService;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idtoken = req.getParameter("id_token");

        resp.getWriter().print(idtoken);

//        try {
//            idTokenValidatorService.getPayload(idtoken);
//            System.out.println(idtoken.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }




}
