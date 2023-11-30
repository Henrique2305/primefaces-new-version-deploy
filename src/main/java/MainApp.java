import javax.faces.webapp.FacesServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.apache.tomcat.util.scan.StandardJarScanner;

public class MainApp {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("", null);

        Tomcat.addServlet(context, "facesServlet", new FacesServlet());
        context.addServletMappingDecoded("*.xhtml", "facesServlet");

        context.addWelcomeFile("index.xhtml");

        tomcat.start();
        tomcat.getServer().await();
    }
}
