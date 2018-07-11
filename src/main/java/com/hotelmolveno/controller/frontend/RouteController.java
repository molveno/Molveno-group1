package com.hotelmolveno.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

// Create a

@Controller
@RequestMapping("/")
public class RouteController {

    @RequestMapping(value="/snortest", method = RequestMethod.GET)
    public String tables(Map<String, Object> model) {
        return "snortest";
    }

}
