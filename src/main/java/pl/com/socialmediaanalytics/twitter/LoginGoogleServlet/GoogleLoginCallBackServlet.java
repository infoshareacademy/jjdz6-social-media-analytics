package pl.com.socialmediaanalytics.twitter.LoginGoogleServlet;


import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/oauth2callback")
public class GoogleLoginCallBackServlet extends AbstractAuthorizationCodeCallbackServlet {


    @Override
    protected AuthorizationCodeFlow initializeFlow() throws ServletException, IOException {
        return GoogleLoginCommons.buildFlow();

    }

    @Override
    protected String getRedirectUri(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        return GoogleLoginCommons.buildRedirectUri(httpServletRequest);

    }

    @Override
    protected String getUserId(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        String randomUserId = UUID.randomUUID().toString();
        return randomUserId;


    }

    @Override
    protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential) throws ServletException, IOException {
        GoogleCredential gCredential = new GoogleCredential().setAccessToken(credential.getAccessToken());
        Oauth2 oauth2 = new Oauth2.Builder(
                new NetHttpTransport(),
                JacksonFactory.getDefaultInstance(),
                gCredential)
                .setApplicationName("Social Media Analytics")
                .build();


        Userinfoplus info = oauth2.userinfo().get().execute();
        String name = info.getName();
        String email = info.getEmail();

        req.getSession().setAttribute("name", name);
        req.getSession().setAttribute("email", email);
        resp.sendRedirect("/main");





    }



}
