package pl.com.socialmediaanalytics.twitter.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;


@WebFilter(
        filterName = "CookieFilter",
        urlPatterns = {"/main"}
)
public class CookieFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String googleUserGoogleName = (String) request.getSession().getAttribute("name");


        Cookie cookieUserGoogleName = new Cookie("google-user-name", googleUserGoogleName);

        cookieUserGoogleName.setMaxAge(60);

        response.addCookie(cookieUserGoogleName);


        request.setAttribute("google-user-name", googleUserGoogleName);


        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {

    }
}
