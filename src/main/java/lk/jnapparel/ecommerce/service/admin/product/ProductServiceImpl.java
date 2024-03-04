package lk.jnapparel.ecommerce.service.admin.product;

import lk.jnapparel.ecommerce.dto.ProductDto;
import lk.jnapparel.ecommerce.entity.Category;
import lk.jnapparel.ecommerce.entity.Color;
import lk.jnapparel.ecommerce.entity.Product;
import lk.jnapparel.ecommerce.entity.Size;
import lk.jnapparel.ecommerce.repository.CategoryRepository;
import lk.jnapparel.ecommerce.repository.ColorRepository;
import lk.jnapparel.ecommerce.repository.ProductRepository;
import lk.jnapparel.ecommerce.repository.SizeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final SizeRepository sizeRepository;
    private final ColorRepository colorRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ModelMapper modelMapper,
                              SizeRepository sizeRepository,
                              ColorRepository colorRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.sizeRepository = sizeRepository;
        this.colorRepository = colorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = convertToEntity(productDto);
        if (productDto.getColorId() != null) {
            Color color = colorRepository
                    .findById(productDto.getColorId()).orElse(null);
            product.setColor(color);
        }
        if (productDto.getSizeId() != null) {
            Size size = sizeRepository
                    .findById(productDto.getSizeId()).orElse(null);
            product.setSize(size);
        }
        if (productDto.getCategoryId() != null) {
            Category category = categoryRepository
                    .findById(productDto.getCategoryId()).orElse(null);
            product.setCategory(category);
        }
        Product savedProduct = productRepository.save(product);
        return convertToDto(savedProduct);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDto)
                .toList();
    }

    private ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product convertToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
