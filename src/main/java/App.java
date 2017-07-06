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
      model.put("cDs", request.session().attribute("cDs"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/cDs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<CD> cDs = request.session().attribute("cDs");
      if (cDs == null) {
        cDs = new ArrayList<CD>();
        request.session().attribute("cDs", cDs);
      }

      String description = request.queryParams("description");
      CD newCD = new CD(description);
      cDs.add(newCD);
      request.session().attribute("cD", newCD);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
