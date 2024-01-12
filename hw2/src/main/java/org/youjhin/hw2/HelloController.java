package org.youjhin.hw2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("greeting", this.helloService.getGreeting());
        model.addAttribute("backgroundColor", "black");
        model.addAttribute("textAlign", "center");
        model.addAttribute("fontSize", "large");

        return "hello";
    }
}
