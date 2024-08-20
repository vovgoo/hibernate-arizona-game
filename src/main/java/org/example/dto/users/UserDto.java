package org.example.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.user.Gender;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String username;

    private String email;

    private String password;

    private Gender gender;

    private Integer level;

    private Integer respect;

    private Integer money;

    private Integer law_abiding;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer countSlotsInInventory;
}
