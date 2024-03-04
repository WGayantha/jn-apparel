package lk.jnapparel.ecommerce.service.admin.color;

import lk.jnapparel.ecommerce.dto.ColorDto;
import lk.jnapparel.ecommerce.entity.Color;
import lk.jnapparel.ecommerce.repository.ColorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;
    private final ModelMapper modelMapper;

    public ColorServiceImpl(ColorRepository colorRepository,
                            ModelMapper modelMapper) {
        this.colorRepository = colorRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ColorDto> getAllColors() {
        List<Color> colors = colorRepository.findAll();
        return colors.stream()
                .map(color -> modelMapper.map(color, ColorDto.class))
                .toList();
    }

    @Override
    public ColorDto saveColor(ColorDto colorDto) {
        Color color = modelMapper.map(colorDto, Color.class);
        Color savedColor = colorRepository.save(color);
        return modelMapper.map(savedColor, ColorDto.class);
    }
}
