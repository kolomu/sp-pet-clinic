package com.kolomu.sppetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // give RequestMapping a list of parameters
    @RequestMapping({"", "/", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/oups")
    public String oupsMethod() {
        return "notimplemented";
    }
}
