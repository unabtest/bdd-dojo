package edu;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;
import java.util.Map;


import edu.model.LoginValidator;
import static spark.Spark.get;
import static spark.Spark.post;

public class Spark {
	
	private static LoginValidator loginValidator= new LoginValidator();

    public static void main(String[] args) {

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("welcome", "Bienvenido a Ananzon la mejor tienda virtual del Pais");
            return new ModelAndView(model, "index.wm");
        }, new VelocityTemplateEngine());

        post("/login", (request, response) -> {
        	
        	String usuario = request.queryParams("usuario");
        	String password = request.queryParams("password");
        	
            Map<String, Object> model = new HashMap<>();
            if(loginValidator.validar(usuario, password)){
            	model.put("saludo", "Bienvenido a Ananzon, " + usuario);
            }
            return new ModelAndView(model, "login.wm");
        }, new VelocityTemplateEngine());

    }

}
