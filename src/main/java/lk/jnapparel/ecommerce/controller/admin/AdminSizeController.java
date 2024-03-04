package lk.jnapparel.ecommerce.controller.admin;

import lk.jnapparel.ecommerce.dto.SizeDto;
import lk.jnapparel.ecommerce.service.admin.size.SizeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/size")
public class AdminSizeController {

    private final SizeService sizeService;

    public AdminSizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @PostMapping()
    ResponseEntity<SizeDto> saveSize(@RequestBody SizeDto sizeDto) {
        SizeDto savedSize = sizeService.saveSize(sizeDto);
        return new ResponseEntity<>(savedSize, HttpStatus.CREATED);
    }

    @GetMapping()
    ResponseEntity<List<SizeDto>> getAllSizes() {
        List<SizeDto> allsizes = sizeService.getAllsizes();
        return new ResponseEntity<>(allsizes, HttpStatus.OK);
    }
}
