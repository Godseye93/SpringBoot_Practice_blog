package SSAFY.demo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BloController {
    @GetMapping("/test/hello")
    public String hello(){
        return "<h1>장칼국수 시켰습니다!<h1>";
    }
}
