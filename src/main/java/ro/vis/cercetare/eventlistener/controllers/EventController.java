package ro.vis.cercetare.eventlistener.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.vis.cercetare.eventlistener.model.Event;
import ro.vis.cercetare.eventlistener.services.EventService;

@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("/input/1")
    public ResponseEntity<String> registerEvent(@RequestBody final Event event) {
        //TODO - Visan Dan - validation and registration exceptions will be caught using AOP
        boolean isValid = eventService.validateEvent(event);
        if (isValid) {
            try {
                eventService.registerEvent(event);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
