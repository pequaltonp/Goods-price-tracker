package my.project.goods_parser.service;

import my.project.goods_parser.model.ShopPropertyDto;

public interface ShopParserService {
    boolean parseShop(String url, ShopPropertyDto shopProperty);
}
