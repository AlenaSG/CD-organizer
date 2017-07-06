import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("places", request.session().attribute("places"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/places", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Place> places = request.session().attribute("places");
      if (places == null) {
        places = new ArrayList<Place>();
        request.session().attribute("places", places);
      }

      String description = request.queryParams("description");
      Place newPlace = new Place(description);
      places.add(newPlace);
      request.session().attribute("place", newPlace);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
