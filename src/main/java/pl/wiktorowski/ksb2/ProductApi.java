package pl.wiktorowski.ksb2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProductApi {


    @GetMapping("/products")
    public String getProducts () {

        return "Hello World with Get";
    }


}
