package sil.looja.loja.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sil.looja.loja.products.model.Product;
import sil.looja.loja.products.repository.ProductRepository;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired

    private ProductRepository productRepository;

    @PostMapping
    public @ResponseBody String addNewProduct(@RequestParam String productName,
                                              @RequestParam double productPrice) {
        Product p = new Product();
        p.setProductName(productName);
        p.setProductPrice(productPrice);
        productRepository.save(p);

        return "Saved";
    }

    @GetMapping
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public @ResponseBody Product getProductById(@PathVariable Integer productId) {
        return productRepository.findById(productId).get();
    }

    @DeleteMapping("/{productId}")
    public @ResponseBody String deleteProductById(@PathVariable Integer productId) {
        productRepository.deleteById(productId);
        return "Deleted";
    }

    @PutMapping("/{productId}")
    public @ResponseBody String updateOneProduct(@PathVariable Integer productId) {
        Product p = productRepository.findById(productId).get();
        p.setProductName("Updated");
        p.setProductPrice(1);
        productRepository.save(p);
        return "Updated";
    }
}
