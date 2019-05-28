package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import twitter4j.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/find-trend")
public class FindByTrendsServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;


    private Trends trends;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        PrintWriter printWriter = resp.getWriter();
//        Map<List<String>, List<Integer>> map = new HashMap<>();
//        map.put(NAME, WOEID);
//
//        Map<String,Map<List<String>,List<Integer>>>dataModelSecond = new HashMap<>();
//        dataModelSecond.put("weoids",map);
//        Map<String, List<String>> dateModel = new HashMap<>();
//        dateModel.put("locations",NAME);
//        dateModel.put("trendList", trendList);
//        dateModel.put("trendListName", trendListName);
//        Template template = templateProvider.getTemplate(getServletContext(), "trend.ftlh");
//        Template template1 = templateProvider.getTemplate(getServletContext(),"trend.ftlh");
//        try {
//            //template.process(dateModel, printWriter);
//            template1.process(dataModelSecond,printWriter);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//
    }
}