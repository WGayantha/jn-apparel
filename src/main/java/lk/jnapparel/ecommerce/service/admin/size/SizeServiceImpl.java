package lk.jnapparel.ecommerce.service.admin.size;

import lk.jnapparel.ecommerce.dto.SizeDto;
import lk.jnapparel.ecommerce.entity.Size;
import lk.jnapparel.ecommerce.repository.SizeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    private final SizeRepository sizeRepository;
    private final ModelMapper modelMapper;

    public SizeServiceImpl(SizeRepository sizeRepository,
                           ModelMapper modelMapper) {
        this.sizeRepository = sizeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SizeDto saveSize(SizeDto sizeDto) {
        Size size = modelMapper.map(sizeDto, Size.class);
        Size savedSize = sizeRepository.save(size);
        return modelMapper.map(savedSize, SizeDto.class);
    }

    @Override
    public List<SizeDto> getAllsizes() {
        List<Size> sizes = sizeRepository.findAll();
        return sizes.stream()
                .map(size -> modelMapper.map(size, SizeDto.class))
                .toList();
    }
}
