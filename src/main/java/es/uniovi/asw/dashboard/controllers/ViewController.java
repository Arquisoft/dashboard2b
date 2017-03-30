package es.uniovi.asw.dashboard.controllers;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    private static final Logger logger = Logger.getLogger(ViewController.class);

    @RequestMapping("/")
    public String landing(Model model) {
        return "index";
    }


}