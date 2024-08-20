package org.example.service.organizations;

import lombok.RequiredArgsConstructor;
import org.example.dao.organizations.BandsRepository;
import org.example.dto.organizations.BandsDto;
import org.example.entity.organizations.Bands;
import org.example.mapper.organizations.BandsMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class BandsService {

    private final BandsRepository bandsRepository;

    private final BandsMapper bandsMapper;

    public Bands create(BandsDto bandsDto) {
        return bandsRepository.save(bandsMapper.mapTo(bandsDto));
    }

    public Optional<Bands> findById(Long id) {
        return bandsRepository.findById(id);
    }
}
