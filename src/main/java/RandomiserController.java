import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class RandomiserController {

    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("/public");
        ArrayList<String> names = new ArrayList<>();

        String name1 = new String("Graeme");
        String name2 = new String("Danny");
        String name3 = new String("Ed");
        String name4 = new String("Jim");
        String name5 = new String("Allan");
        String name6 = new String("Angus");
        String name7 = new String("Steve");
        String name8 = new String("Paul");

        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);
        names.add(name6);
        names.add(name7);
        names.add(name8);

//        Collections.shuffle(names);

        get("/one", (Request req, Response res) -> {
            Collections.shuffle(names);
            HashMap<String, Object> model = new HashMap<>();
            model.put("result", names.get(0));
            model.put("template", "result.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

        get("/two", (req, res) -> {
            Collections.shuffle(names);
            HashMap<String, Object> model = new HashMap<>();
            model.put("result", names);
            model.put("template", "pairs.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

        get("/three", (req, res) -> {
            Collections.shuffle(names);
            HashMap<String, Object> model = new HashMap<>();
            model.put("result", names);
            model.put("template", "trios.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

        get("/four", (req, res) -> {
            Collections.shuffle(names);
            HashMap<String, Object> model = new HashMap<>();
            model.put("result", names);
            model.put("template", "quads.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);
    }


}
