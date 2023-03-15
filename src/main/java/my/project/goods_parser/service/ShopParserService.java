package my.project.goods_parser.service;

import my.project.goods_parser.model.EShopPropertyProjection;

public interface ShopParserService {
    boolean parseShop(String url, EShopPropertyProjection shopProperty);
}
