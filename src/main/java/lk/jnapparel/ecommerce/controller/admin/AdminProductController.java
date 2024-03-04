package lk.jnapparel.ecommerce.controller.admin;

import lk.jnapparel.ecommerce.dto.ProductDto;
import lk.jnapparel.ecommerce.service.admin.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/product")
public class AdminProductController {

    private final ProductService productService;

    public AdminProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.saveProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping()
    ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
