package org.demo.validation;

import org.demo.validation.model.GreetingsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/greetings")
public class GreetingsController {

    @PostMapping
    public ResponseEntity<String> greetings (@RequestBody @Valid GreetingsRequest request) {
        String formattedGreetings =  String.format("Is a valid name!! So hello %s %s",
                request.getFirstName(), request.getLastName());
        return ResponseEntity.ok(formattedGreetings);











    }
}
