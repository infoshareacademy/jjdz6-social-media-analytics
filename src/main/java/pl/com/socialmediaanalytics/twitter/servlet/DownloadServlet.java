package pl.com.socialmediaanalytics.twitter.servlet;

import pl.com.socialmediaanalytics.twitter.presentation.TweetPresentationObjectDTO;
import pl.com.socialmediaanalytics.twitter.service.FileGeneratorService;
import pl.com.socialmediaanalytics.twitter.service.JsonParserService;
import pl.com.socialmediaanalytics.twitter.service.TwitterSearchService;
import twitter4j.Status;
import twitter4j.TwitterException;

import javax.inject.Inject;
import javax.net.ssl.SSLEngineResult;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    private final int ARBITARY_SIZE = 1048;

    @Inject
    FileGeneratorService fileGeneratorService;

    @Inject
    TwitterSearchService twitterSearchService;

    @Inject
    JsonParserService jsonParserService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       // PrintWriter writer = resp.getWriter();

        String optionParam = req.getParameter("option");
        String textParam = req.getParameter("text");
        String langParam = req.getParameter("lang");
        String dateParam = req.getParameter("date");

        if(optionParam == null || optionParam.isEmpty() || textParam == null || textParam.isEmpty()
                || langParam == null|| langParam.isEmpty() || dateParam == null || dateParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            //writer.println("<H1>" + resp.getStatus() + "- BAD REQUEST!</H1>");
            return;
        }

        List<Status> statuses = null;
        try {
            statuses = twitterSearchService.searchTweets(textParam, dateParam,langParam, optionParam);
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        String json = jsonParserService.toJson(statuses);
        System.out.println(json);

        String filename = fileGeneratorService.saveToFile(json);

        resp.setContentType("text/plain");
        resp.setHeader("Content-disposition", "attachment; filename=" + filename);

        try(InputStream in = req.getServletContext().getResourceAsStream(filename);
            OutputStream out = resp.getOutputStream()) {

            byte[] buffer = new byte[ARBITARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}
