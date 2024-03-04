package lk.jnapparel.ecommerce.controller.admin;

import lk.jnapparel.ecommerce.dto.ColorDto;
import lk.jnapparel.ecommerce.service.admin.color.ColorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminColorController {

    private final ColorService colorService;

    public AdminColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping("/color")
    ResponseEntity<ColorDto> saveColor(@RequestBody ColorDto colorDto) {
        ColorDto savedColor = colorService.saveColor(colorDto);
        return new ResponseEntity<>(savedColor, HttpStatus.CREATED);
    }

    @GetMapping("/color")
    ResponseEntity<List<ColorDto>> getAllColors() {
        List<ColorDto> allColors = colorService.getAllColors();
        return new ResponseEntity<>(allColors, HttpStatus.OK);
    }
}
