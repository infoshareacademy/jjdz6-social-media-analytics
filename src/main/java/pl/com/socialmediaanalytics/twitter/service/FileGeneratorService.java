package pl.com.socialmediaanalytics.twitter.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequestScoped
public class FileGeneratorService {

    //private static final String TEMP_FILES_DIRECTORY = "/WEB-INF/temp-files/";


    @Inject
    JsonParserService jsonParserService;

    public String saveToFile(String json){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyhhmmssms");
        String filename = "tmp" + LocalDateTime.now().format(dateTimeFormatter) + ".json";
        Path path = Paths.get(filename);
        try {
            Files.write(path, json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }


}
