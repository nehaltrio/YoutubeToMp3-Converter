package com.example.youtubetomp3.Controllers;

import com.example.youtubetomp3.APIs.ApiUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String show(Model model) {
        model.addAttribute("apis", new ApiUtils());
        return "index";
    }

    @PostMapping("/home")
    public String submit(@ModelAttribute ApiUtils api, Model model) {
        model.addAttribute("apis", api);
        return "download";
    }

}
