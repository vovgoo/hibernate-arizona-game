package org.example.dto.serverItems;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.items.Items;
import org.example.entity.user.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerItemDto {

    private Long id;

    private Items items;

    private User user;

    private Integer slots_id;
}
