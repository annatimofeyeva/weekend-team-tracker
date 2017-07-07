import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
//create a route that render homepage (add a Team, view all teams)
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("team", request.session().attribute("team"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
//create a post route after user click submit button
    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String description = request.queryParams("description");
      Team newTeam = new Team(description);
      request.session().attribute("team", newTeam);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  /*on order to display our team in index template - the roort route
  must retrive it from the user session. Then it will need to provide it
  to the index template - so we need to modify our get ("/")route
  and after this we also need to modify index.vtl*/


  }
}
