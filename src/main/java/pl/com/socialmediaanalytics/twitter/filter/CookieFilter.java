package pl.com.socialmediaanalytics.twitter.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.Matcher;

@WebFilter(
        filterName = "CookieFilter",
        urlPatterns = {"/search-user","/map-trends","/find-trend"}
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
        String param = request.getParameter("param");

        Cookie cookieUser = new Cookie("find-user", name);
        Cookie cookieTrend= new Cookie("find-trend", place);
        Cookie cookieClient= new Cookie("find-trend-place", param);

        response.addCookie(cookieUser);
        response.addCookie(cookieTrend);
        response.addCookie(cookieClient);

        request.setAttribute("find-user",name);
        request.setAttribute("find-trend-map",place);
        request.setAttribute("find-trend-place",param);



        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {

    }
}
