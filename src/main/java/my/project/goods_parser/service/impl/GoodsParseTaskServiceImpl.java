package my.project.goods_parser.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import my.project.goods_parser.entity.ShopParseTaskEntity;
import my.project.goods_parser.model.GoodsParseTaskDto;
import my.project.goods_parser.repository.ShopParseTaskRepository;
import my.project.goods_parser.service.GoodsParseTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GoodsParseTaskServiceImpl implements GoodsParseTaskService {
    private final ShopParseTaskRepository parseTaskRepository;

    @Override
    public boolean addToQueue(GoodsParseTaskDto taskDto) {
        return parseTaskRepository.save(ShopParseTaskEntity.builder()
                        .shopName(taskDto.getShopName())
                        .url(taskDto.getUrl())
                        .lastParseDate(LocalDateTime.MIN)
                        .build())
                .getId() != 0;
    }

    @Override
    public List<GoodsParseTaskDto> getParsedTaskByShopName(@NonNull String shopName) {
        return parseTaskRepository.findShopParseTaskEntitiesByShopName(shopName).stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public GoodsParseTaskDto getParsedTaskByUrl(String url) {
        return parseTaskRepository.findShopParseTaskEntityByUrl(url)
                .map(this::entityToModel)
                .orElseGet(GoodsParseTaskDto::new);
    }

    @Override
    public List<GoodsParseTaskDto> getLast10NotParsedTaskByDateTime() {
        return parseTaskRepository.findShopParseTaskEntitiesByLastParseDateBefore(LocalDateTime.now()).stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    private GoodsParseTaskDto entityToModel(ShopParseTaskEntity entity) {
        return GoodsParseTaskDto.builder()
                .id(entity.getId())
                .lastParseDate(entity.getLastParseDate())
                .url(entity.getUrl())
                .shopName(entity.getShopName())
                .build();
    }

}
