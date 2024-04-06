package crud.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Specify @Configuration and/or @Component classes for "root" application context (non-web infrastructure) configuration.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                HibernateConfig.class
        };
    }

    // Specify @Configuration and/or @Component classes for DispatcherServlet application context (Spring MVC infrastructure) configuration.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    // Specify the servlet mapping(s) for the DispatcherServlet — for example "/", "/app", etc.
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
