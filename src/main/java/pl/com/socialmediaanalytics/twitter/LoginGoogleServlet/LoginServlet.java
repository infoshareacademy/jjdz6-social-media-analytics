package pl.com.socialmediaanalytics.twitter.LoginGoogleServlet;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/googlelogin")
public class LoginServlet extends AbstractAuthorizationCodeServlet {
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
        return UUID.randomUUID().toString();
    }
}
