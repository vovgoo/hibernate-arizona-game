package org.example.service.serverItems;

import lombok.RequiredArgsConstructor;
import org.example.dao.serverItems.ServerItemRepository;
import org.example.entity.user.User;

@RequiredArgsConstructor
public class ServerItemService {

    private final ServerItemRepository serverItemRepository;

    public boolean canExist(Long userId, Integer slotsId) {
        return serverItemRepository.findByUserIdAndSlotsId(userId, slotsId);
    }

    public boolean haveEmptySlots(User user) {
        return serverItemRepository.haveEmptySlot(user);
    }

    public Integer getEmptySlot(User user) {
        return serverItemRepository.getEmptySlot(user);
    }

}
