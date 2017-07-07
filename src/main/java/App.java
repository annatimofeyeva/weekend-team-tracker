import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
//create a route that render homepage (add a Team, view all teams)
  public ("/"), (request, response) -> {
    Map<String, Object> model = new HashMap,String, Object>();
    model.put("template," "templates/index.vtl");
    return new ModelAndView(model, layout);
  }

  }
}
