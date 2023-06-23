package com.Tutorial.Controller;

import com.Tutorial.Model.Product;
import com.Tutorial.Reporsitory.CustomerRepository;
import com.Tutorial.Reporsitory.OrderRepository;
import com.Tutorial.Reporsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StreamApi {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CustomerRepository CustomerRepo;

    @Autowired
    private OrderRepository orderRepo;

//    Obtain a list of products belongs to category “Books” with price > (given price)

    @GetMapping("/product")
    public List<Product> getProductByCategory(@RequestParam String category,@RequestParam long price){
         List<Product> result = productRepo.findAll()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .filter(p -> p.getPrice() > price)
                .collect(Collectors.toList());
         return result;
    }


}
