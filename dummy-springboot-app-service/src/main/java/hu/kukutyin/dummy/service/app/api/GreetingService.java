package hu.kukutyin.dummy.service.app.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class GreetingService {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/greeting"
    )
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello World!");
    }
}
