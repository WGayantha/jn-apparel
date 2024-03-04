package lk.jnapparel.ecommerce.service.admin.product;

import lk.jnapparel.ecommerce.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
}
