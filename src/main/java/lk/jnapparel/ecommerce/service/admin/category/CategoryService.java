package lk.jnapparel.ecommerce.service.admin.category;

import lk.jnapparel.ecommerce.dto.CategoryDto;


import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    CategoryDto saveCategory(CategoryDto categoryDto);

}
