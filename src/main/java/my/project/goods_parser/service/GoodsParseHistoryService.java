package my.project.goods_parser.service;

import my.project.goods_parser.entity.GoodsParseHistoryEntity;
import my.project.goods_parser.model.GoodsParseHistoryDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface GoodsParseHistoryService {
    void saveGoodsParseHistory(GoodsParseHistoryDto goodsParseHistoryDto);
    List<GoodsParseHistoryDto> getGoodsParseHistoryByName(String name);
    List<GoodsParseHistoryDto> getGoodsParseHistoryByParsedDateTime(LocalDateTime parsedDateTime);
    GoodsParseHistoryDto getGoodsParseHistoryById(long id);
}
