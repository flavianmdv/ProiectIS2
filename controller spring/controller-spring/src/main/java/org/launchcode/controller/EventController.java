package org.launchcode.controller;


import org.launchcode.data.EventData;
import org.launchcode.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

        @GetMapping
        public String displayAllEvents(Model model) {

            model.addAttribute("events", EventData.getAll());
            return "events/index";
        }

        @GetMapping("create")
        public String renderCreateEventForm() {
            return "events/create";
        }

        @PostMapping("create")
        public String processCreateEventForm(@ModelAttribute Event newEvent) {
            EventData.add(newEvent);
            return "redirect:/events";
        }

        @GetMapping("delete")
        public String renderDeleteEventForm(Model model) {
            model.addAttribute("title", "Delete Events");
            model.addAttribute("events", EventData.getAll());
            return "events/delete";
        }

        @PostMapping("delete")
        public String procesDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
            if (eventIds != null) {
                for (int id : eventIds) {
                    EventData.remove(id);
                }
            }
            return "redirect:/events";
        }
}
