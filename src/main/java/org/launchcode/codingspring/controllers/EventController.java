package org.launchcode.codingspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    //private static List<String> events = new ArrayList<>();
    private static HashMap<String, String> events = new HashMap<String, String>();

    @GetMapping
    public String displayAllEvents(Model model) {
        events.put("JavaScript", "discussion about how to use javascript");
        events.put("WWB", "conference about the internet");
        events.put("LaunchCode", "nonprofit look at learning coding");
        model.addAttribute("events", events);
        return "Events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "Events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription) {
        events.put(eventName, eventDescription);
        return "redirect:";
    }

}
