package pl.com.socialmediaanalytics.twitter.LoginGoogleServlet;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GoogleLoginCommons {

    private static final List<String> scopes = new ArrayList<>();

    public static List<String> listScopes() {
        scopes.add("openid");
        scopes.add("email");
        scopes.add("profile");
        return scopes;
    }

    private static final String clientId = "343502052313-vk4bvpo1f72q6b0sh1hemqt5u7lt1fdg.apps.googleusercontent.com";

    private static final String secret = "FYnUuinvDzknWrty05mXLt7o";

    private static final String redirectUrl = "/oauth2callback";


    public static String buildRedirectUri(HttpServletRequest req) {
        GenericUrl url = new GenericUrl(req.getRequestURL().toString());
        url.setRawPath(redirectUrl);
        return url.build();
    }

    public static GoogleAuthorizationCodeFlow buildFlow() {
        return new GoogleAuthorizationCodeFlow.Builder(
                new NetHttpTransport(),
                JacksonFactory.getDefaultInstance(),
                clientId,
                secret,
                listScopes()
        )

                .setAccessType("online")
                .build();
    }
}

