package org.academiadecodigo.javabank.controller.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

        @RequestMapping(method = RequestMethod.GET, value = "/api/hello")
        public ResponseEntity<String> helloWorld(){
            return new ResponseEntity<>( "Hello World", HttpStatus.I_AM_A_TEAPOT);
        }
}
