package pe.skillnest.ddd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.skillnest.ddd.domain.dto.ProductDto;
import pe.skillnest.ddd.domain.services.ProductServices;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping
    public String createBook(@RequestBody ProductDto productDto) {
        productServices.Save(productDto);
        return "YOLO";
    }

}
