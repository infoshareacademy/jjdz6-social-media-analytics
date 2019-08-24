package pl.com.socialmediaanalytics.twitter.configurator;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.io.IOException;

@RequestScoped
public class TemplateProvider {
    private final String TEMPLATES_DIRECTORY_PATH = "/WEB-INF/tm-templates";
    private Configuration configuration;

    @Inject
    private ConfigProvider configProvider;

    public Template getTemplate(ServletContext servletContext, String templateName) throws IOException {

        configuration = configProvider.getConfigurationgon();
        configuration.setServletContextForTemplateLoading(servletContext, TEMPLATES_DIRECTORY_PATH);
        return configuration.getTemplate(templateName);

    }


}