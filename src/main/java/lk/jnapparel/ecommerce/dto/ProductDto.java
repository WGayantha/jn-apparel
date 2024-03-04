package lk.jnapparel.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private String sku;
    private double price;
    private String productImage;
    private int qtyInStock;
    private Long colorId;
    private Long sizeId;
    private Long categoryId;

}
