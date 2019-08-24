package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.dto.TrendDTO;
import pl.com.socialmediaanalytics.twitter.service.TrendTDOService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/maps-stream")
public class MapStreamServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private TrendTDOService trendTDOService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        stringList.add("German");
        stringList.add("Warsaw");
        stringList.add("Paris");
        stringList.add("Italy");
        stringList.add("Moscow");
        stringList.add("Sweden");
        stringList.add("Ukraine");
        stringList.add("Norway");
        stringList.add("England");
        stringList.add("China");
        stringList.add("New York");


        TrendDTO dt0 = trendTDOService.getTrendDTObyCoordinates(stringList.get(0));
        TrendDTO dt1 = trendTDOService.getTrendDTObyCoordinates(stringList.get(1));
        TrendDTO dt2 = trendTDOService.getTrendDTObyCoordinates(stringList.get(2));
        TrendDTO dt3 = trendTDOService.getTrendDTObyCoordinates(stringList.get(3));
        TrendDTO dt4 = trendTDOService.getTrendDTObyCoordinates(stringList.get(4));
        TrendDTO dt5 = trendTDOService.getTrendDTObyCoordinates(stringList.get(5));
        TrendDTO dt6 = trendTDOService.getTrendDTObyCoordinates(stringList.get(6));
        TrendDTO dt7 = trendTDOService.getTrendDTObyCoordinates(stringList.get(7));
        TrendDTO dt8 = trendTDOService.getTrendDTObyCoordinates(stringList.get(8));
        TrendDTO dt9 = trendTDOService.getTrendDTObyCoordinates(stringList.get(9));
        TrendDTO dt10 = trendTDOService.getTrendDTObyCoordinates(stringList.get(10));


        model.put("trendsBerlin", dt0);
        model.put("trendsWarsaw", dt1);
        model.put("trendsParis", dt2);
        model.put("trendsItaly", dt3);
        model.put("trendsMoscow", dt4);
        model.put("trendsSweden", dt5);
        model.put("trendsUkraine", dt6);
        model.put("trendsNorway", dt7);
        model.put("trendsEngland", dt8);
        model.put("trendsChina", dt9);
        model.put("trendsNewYork", dt10);


        Template template = templateProvider.getTemplate(getServletContext(), "streammap.ftlh");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException te) {
            te.printStackTrace();
        }

    }


}




