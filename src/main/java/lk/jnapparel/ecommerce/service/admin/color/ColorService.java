package lk.jnapparel.ecommerce.service.admin.color;

import lk.jnapparel.ecommerce.dto.ColorDto;

import java.util.List;

public interface ColorService {

    List<ColorDto> getAllColors();

    ColorDto saveColor(ColorDto colorDto);
}
