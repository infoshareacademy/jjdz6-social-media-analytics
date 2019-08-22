package pl.com.socialmediaanalytics.twitter.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.Matcher;

@WebFilter(
        filterName = "CookieFilter",
        urlPatterns = "/*"
)
public class CookieFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        String name = request.getParameter("name");
        String place = request.getParameter("place");
        String param = (String)request.getSession().getAttribute("param");
        String googleUserName = (String) request.getSession().getAttribute("name");

        Cookie cookieUser = new Cookie("find-user", name);
        Cookie cookieTrend= new Cookie("find-trend", place);
        Cookie cookiePlace= new Cookie("find-trend-place", param);
        Cookie cookieUserName = new Cookie("google-user-name",googleUserName);

        cookieUser.setMaxAge(0);
        cookieTrend.setMaxAge(0);
        cookiePlace.setMaxAge(0);
        cookieUserName.setMaxAge(0);

        response.addCookie(cookieUser);
        response.addCookie(cookieTrend);
        response.addCookie(cookiePlace);
        response.addCookie(cookieUserName);

        request.setAttribute("find-user",name);
        request.setAttribute("find-trend-map",place);
        request.setAttribute("find-trend-place",param);
        request.setAttribute("google-user-name",googleUserName);



        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {

    }
}
