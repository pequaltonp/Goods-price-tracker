package my.project.goods_parser.service;


import my.project.goods_parser.model.ShopPropertyDto;

import java.util.Optional;

public interface ShopPropertyService {
    Optional<ShopPropertyDto> shopDomainValidate(String url);
    ShopPropertyDto getShopPropertyByName(String name);
}
