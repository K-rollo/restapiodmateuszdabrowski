package pl.karolkoduje.restapiodmateuszdabrowski.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karolkoduje.restapiodmateuszdabrowski.service.HelloService;

@RestController
@RequiredArgsConstructor
public class HelloController {

//----Wstrzykiwanie beana przez adnotację Autowired
//    @Autowired
//    private HelloService helloService;

    private final HelloService helloService;    // Adnotacja RequiredArgsConstructor załatwia wstrzykiwanie

//----Wstrzykiwanie beana przez settera
//    @Autowired
//    public void setHelloService(Helloservice helloService) {
//       this.helloService = helloService;

//----Wstrzykiwanie beana przez konstruktor
//    Adnotacja Autowired nie jest wymagana - Spring sam ją czyta domyślnie
//    public HelloController(HelloService helloService) {
//        this.helloService = helloService;
//    }

    @GetMapping("/")
    public String hello() {
        return helloService.hello();
    }
}
