package hu.kukutyin.own.app.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HealthCheckService {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/healthcheck"
    )
    public ResponseEntity<Void> healthCheck() {
        return ResponseEntity.ok().build();
    }
}
