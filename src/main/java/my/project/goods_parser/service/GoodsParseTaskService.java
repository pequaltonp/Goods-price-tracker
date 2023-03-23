package my.project.goods_parser.service;

import my.project.goods_parser.model.GoodsParseHistoryDto;
import my.project.goods_parser.model.GoodsParseTaskDto;

import java.time.LocalDateTime;
import java.util.List;

public interface GoodsParseTaskService {
    boolean addToQueue(GoodsParseTaskDto taskDto);
    void addParseHistory(long taskId, GoodsParseHistoryDto parseHistoryDto);
    List<GoodsParseTaskDto> getParsedTaskByShopName(String shopName);
    GoodsParseTaskDto getParsedTaskByUrl(String url);
}
