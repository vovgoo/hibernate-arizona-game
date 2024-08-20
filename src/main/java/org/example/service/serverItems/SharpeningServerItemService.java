package org.example.service.serverItems;


import org.example.dao.serverItems.ServerItemRepository;
import org.example.dao.serverItems.SharpeningServerItemRepository;
import org.example.dto.serverItems.SharpeningServerItemDto;
import org.example.entity.serverItems.Sharpening;
import org.example.mapper.serverItems.SharpeningServerItemMapper;

public class SharpeningServerItemService extends ServerItemService {

    private final SharpeningServerItemRepository sharpeningServerItemRepository;

    private final SharpeningServerItemMapper sharpeningServerItemMapper;

    public SharpeningServerItemService(ServerItemRepository serverItemRepository, SharpeningServerItemRepository sharpeningServerItemRepository, SharpeningServerItemMapper sharpeningServerItemMapper) {
        super(serverItemRepository);
        this.sharpeningServerItemRepository = sharpeningServerItemRepository;
        this.sharpeningServerItemMapper = sharpeningServerItemMapper;
    }

    public Sharpening create(SharpeningServerItemDto sharpeningServerItemDto) {
        return sharpeningServerItemRepository.save(sharpeningServerItemMapper.mapTo(sharpeningServerItemDto));
    }

}
