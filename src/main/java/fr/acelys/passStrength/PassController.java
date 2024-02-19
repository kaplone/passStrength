package fr.acelys.passStrength;

import fr.acelys.passStrength.RandomGeneration.Complexity;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PassController {

    private final char COMA = 7;
    private final char EQ = 0;
    private final char QUOTES = 26;

    @Autowired
    private PassService passService;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @GetMapping("/pass/{length}/{count}")
    public ResponseEntity<String> getPass(@PathVariable("length") Integer length, @PathVariable("count") Integer count){

        List<String> tmp = passService.getPass(length, count);

        PassResponseDto passResponseDto = new PassResponseDto();
        for (String s : tmp){
            passResponseDto.getPassValues().put(s.replace(',', COMA).replace('"', QUOTES).replace('=', EQ), new Complexity(s).getScore());
        }

        return ResponseEntity.ok(passResponseDto.toString());
    }
}
