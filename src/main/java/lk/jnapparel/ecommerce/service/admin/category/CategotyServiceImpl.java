package lk.jnapparel.ecommerce.service.admin.category;

import jakarta.transaction.Transactional;
import lk.jnapparel.ecommerce.dto.CategoryDto;
import lk.jnapparel.ecommerce.entity.Category;
import lk.jnapparel.ecommerce.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategotyServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategotyServiceImpl(CategoryRepository categoryRepository,
                               ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return null;
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = convertToEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return convertToDto(savedCategory);
    }

    private CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        if(category.getParentCategory() != null) {
            categoryDto.setParentCategoryId(category.getParentCategory().getId());
        }
        return categoryDto;
    }

    private Category convertToEntity(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        if(categoryDto.getParentCategoryId() != null) {
            Category parentCategory = categoryRepository
                    .findById(categoryDto.getParentCategoryId()).orElse(null);
            category.setParentCategory(parentCategory);
        }
        return category;
    }
}
