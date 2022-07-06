package test.mingorance.istio.springservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import test.mingorance.istio.springservice.service.ApplicationService;

@Controller
public class HomeController {

    private final ApplicationService applicationService;

    public HomeController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("number", this.applicationService.getApplicationId());
        return "home/index";
    }
}