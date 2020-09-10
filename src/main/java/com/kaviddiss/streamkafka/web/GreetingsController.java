package com.kaviddiss.streamkafka.web;

import com.kaviddiss.streamkafka.model.Greetings;
import com.kaviddiss.streamkafka.service.GreetingsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {
    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping("/greetings/{msg}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@PathVariable("msg") String message) {
        Greetings greetings = Greetings.builder()
            .message(message)
            .timestamp(System.currentTimeMillis())
            .build();

        greetingsService.sendGreeting(greetings);
    }
}
