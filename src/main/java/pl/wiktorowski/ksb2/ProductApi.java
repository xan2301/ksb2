package pl.wiktorowski.ksb2;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")

public class ProductApi {

    //PARAMETR


//    @GetMapping
//    public String getProducts ( @RequestParam String name ,
//                                @RequestParam(required = false, defaultValue = " ") String surname) {
//
//        return "Hello " + name + " " + surname;
//    }


    //PATH


//    @GetMapping("/{name}")
//
//    public String getProducts(@PathVariable String name){
//
//        return "Hello " + name;
//    }


    //HEADER

//    @GetMapping
//
//    public String getProducts(@RequestHeader String name){
//
//        return "Hello " + name;
//    }

//BODY
    @GetMapping

    public String getProducts(@RequestBody String name){

        return "Hello " + name;
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
