package org.example.mapper.organizations;

import org.example.dto.organizations.BandsDto;
import org.example.entity.organizations.Bands;
import org.example.mapper.Mapper;

public class BandsMapper implements Mapper<Bands, BandsDto> {

    @Override
    public BandsDto mapFrom(Bands object) {
        return BandsDto.builder()
                .name(object.getName())
                .users(object.getUsers())
                .ammo(object.getAmmo())
                .medicineChest(object.medicineChest)
                .build();
    }

    @Override
    public Bands mapTo(BandsDto object) {
        return Bands.builder()
                .name(object.getName())
                .users(object.getUsers())
                .ammo(object.getAmmo())
                .medicineChest(object.medicineChest)
                .build();
    }
}
