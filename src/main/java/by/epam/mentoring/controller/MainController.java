package by.epam.mentoring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {

//    @RequestMapping("/welcome")
//    public ModelAndView helloWorld() {
//
//        String message = "<br><div style='text-align:center;'>"
//                + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
//        return new ModelAndView("welcome", "message", message);
//    }

    @GetMapping
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "welcome";

    }
}
