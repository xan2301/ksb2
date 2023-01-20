package pl.wiktorowski.ksb2;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")

public class ProductApi {


    @GetMapping
    public String getProducts ( @RequestParam String name , @RequestParam String surname) {

        return "Hello " + name + " " + surname;
    }





   @PostMapping
    public String postProducts () {

        return "Hello World with Post";
    }

    @PutMapping
    public String putProducts () {

        return "Hello World with Put";
    }

    @DeleteMapping
    public String removeProducts () {

        return "Hello World with Delete";
    }



}
