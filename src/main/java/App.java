import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "template/layout.vtl";
//create a route that render homepage (add a Team, view all teams)
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", request.session().attribute("teams"));
      model.put("template", "template/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
//create a post route after user click submit button
    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
/*create the arrayList for teams - to create ans display
multiple teams in the session and display them all in the template*/
      ArrayList<Team> teams = request.session().attribute("teams");
      if (teams == null) {
        teams = new ArrayList<Team>();
        request.session().attribute("teams", teams);
      }

      String description = request.queryParams("description");
      Team newTeam = new Team(description);
      teams.add(newTeam);

      model.put("template", "template/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  /*on order to display our team in index template - the roort route
  must retrive it from the user session. Then it will need to provide it
  to the index template - so we need to modify our get ("/")route
  and after this we also need to modify index.vtl*/


  }
}
