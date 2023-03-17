package my.project.goods_parser.service;

import my.project.goods_parser.model.GoodsParseTaskDto;

import java.time.LocalDateTime;
import java.util.List;

public interface GoodsParseTaskService {
    boolean addToQueue(GoodsParseTaskDto taskDto);
    List<GoodsParseTaskDto> getParsedTaskByShopName(String shopName);
    GoodsParseTaskDto getParsedTaskByUrl(String url);
    List<GoodsParseTaskDto> getLast10NotParsedTaskByDateTime();
}
