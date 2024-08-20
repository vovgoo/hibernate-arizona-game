package org.example.mapper.users;

import org.example.dto.users.UserDto;
import org.example.entity.user.User;
import org.example.mapper.Mapper;

public class UserMapper implements Mapper<User, UserDto> {

    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .username(object.getUsername())
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(object.getGender())
                .level(object.getLevel())
                .respect(object.getRespect())
                .money(object.getMoney())
                .law_abiding(object.getLaw_abiding())
                .createdAt(object.getCreatedAt())
                .updatedAt(object.getUpdatedAt())
                .countSlotsInInventory(object.getCountSlotsInInventory())
                .build();
    }

    @Override
    public User mapTo(UserDto object) {
        return User.builder()
                .id(object.getId())
                .username(object.getUsername())
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(object.getGender())
                .level(object.getLevel())
                .respect(object.getRespect())
                .money(object.getMoney())
                .law_abiding(object.getLaw_abiding())
                .createdAt(object.getCreatedAt())
                .updatedAt(object.getUpdatedAt())
                .countSlotsInInventory(object.getCountSlotsInInventory())
                .build();
    }
}
