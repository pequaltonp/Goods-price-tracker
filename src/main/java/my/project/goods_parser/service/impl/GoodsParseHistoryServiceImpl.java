package my.project.goods_parser.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import my.project.goods_parser.entity.GoodsParseHistoryEntity;
import my.project.goods_parser.entity.ShopParseTaskEntity;
import my.project.goods_parser.model.GoodsParseHistoryDto;
import my.project.goods_parser.model.GoodsParseTaskDto;
import my.project.goods_parser.repository.GoodsParseHistoryRepository;
import my.project.goods_parser.service.GoodsParseHistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GoodsParseHistoryServiceImpl implements GoodsParseHistoryService {
    private final GoodsParseHistoryRepository parseHistoryRepository;

    @Override
    public void saveGoodsParseHistory(GoodsParseHistoryDto goodsParseHistoryDto) {
        parseHistoryRepository.save(modelToEntity(goodsParseHistoryDto));
    }

    @Override
    public List<GoodsParseHistoryDto> getGoodsParseHistoryByName(String name) {
        return parseHistoryRepository.findGoodsParseHistoryEntitiesByGoodsName(name).stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<GoodsParseHistoryDto> getGoodsParseHistoryByParsedDate(LocalDate parsedDate) {
        return parseHistoryRepository.findGoodsParseHistoryEntitiesByParsedDate(parsedDate).stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public GoodsParseHistoryDto getGoodsParseHistoryById(long id) {
        return parseHistoryRepository.findGoodsParseHistoryEntitiesById(id)
                .stream()
                .map(this::entityToModel)
                .findFirst()
                .orElseGet(GoodsParseHistoryDto::new);
    }

    private GoodsParseHistoryEntity modelToEntity(@NonNull GoodsParseHistoryDto parseHistoryDto) {
        return GoodsParseHistoryEntity.builder()
                .id(parseHistoryDto.getId())
                .price(parseHistoryDto.getPrice())
                .goodsName(parseHistoryDto.getGoodsName())
                .parsedDate(parseHistoryDto.getParsedDate())
                .build();
    }

    private GoodsParseHistoryDto entityToModel(@NonNull GoodsParseHistoryEntity parseHistory) {
        ShopParseTaskEntity entity = parseHistory.getShopParseTask();
        return GoodsParseHistoryDto.builder()
                .id(parseHistory.getId())
                .price(parseHistory.getPrice())
                .goodsName(parseHistory.getGoodsName())
                .parsedDate(parseHistory.getParsedDate())
                .parseTaskDto(entity == null ? new GoodsParseTaskDto() : GoodsParseTaskDto.builder()
                        .id(entity.getId())
                        .lastParseDate(entity.getLastParseDate())
                        .url(entity.getUrl())
                        .shopName(entity.getShopName())
                        .build())
                .build();
    }
}
