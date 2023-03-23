package my.project.goods_parser.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import my.project.goods_parser.entity.GoodsParseHistoryEntity;
import my.project.goods_parser.entity.ShopParseTaskEntity;
import my.project.goods_parser.model.GoodsParseHistoryDto;
import my.project.goods_parser.model.GoodsParseTaskDto;
import my.project.goods_parser.repository.ShopParseTaskRepository;
import my.project.goods_parser.service.GoodsParseTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GoodsParseTaskServiceImpl implements GoodsParseTaskService {
    private final ShopParseTaskRepository parseTaskRepository;

    @Override
    public boolean addToQueue(GoodsParseTaskDto taskDto) {
        if (parseTaskRepository.findShopParseTaskEntityByUrl(taskDto.getUrl())
                .isPresent())
            return false;

        return parseTaskRepository.save(ShopParseTaskEntity.builder()
                        .shopName(taskDto.getShopName())
                        .url(taskDto.getUrl())
                        .lastParseDate(taskDto.getLastParseDate())
                        .build())
                .getId() != 0;
    }

    @Override
    public void addParseHistory(long taskId, GoodsParseHistoryDto parseHistoryDto) {
        Optional<ShopParseTaskEntity> taskEntityOptional = parseTaskRepository.findById(taskId);
        if (taskEntityOptional.isPresent()) {
            ShopParseTaskEntity taskEntity = taskEntityOptional.get();
            taskEntity.addParseHistory(GoodsParseHistoryEntity.builder()
                            .parsedDate(parseHistoryDto.getParsedDate())
                            .goodsName(parseHistoryDto.getGoodsName())
                            .price(parseHistoryDto.getPrice())
                    .build());
        }
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

    private GoodsParseTaskDto entityToModel(ShopParseTaskEntity entity) {
        return GoodsParseTaskDto.builder()
                .id(entity.getId())
                .lastParseDate(entity.getLastParseDate())
                .url(entity.getUrl())
                .shopName(entity.getShopName())
                .build();
    }

}
