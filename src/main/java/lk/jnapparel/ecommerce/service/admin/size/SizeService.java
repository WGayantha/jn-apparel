package lk.jnapparel.ecommerce.service.admin.size;

import lk.jnapparel.ecommerce.dto.SizeDto;

import java.util.List;

public interface SizeService {
    SizeDto saveSize(SizeDto sizeDto);

    List<SizeDto> getAllsizes();
}
