package my.project.goods_parser.service.impl;

import lombok.RequiredArgsConstructor;
import my.project.goods_parser.model.ShopPropertyDto;
import my.project.goods_parser.repository.EShopPropertyRepository;
import my.project.goods_parser.service.ShopPropertyService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShopPropertyServiceImpl implements ShopPropertyService {
    private final EShopPropertyRepository shopPropertyRepository;

    @Override
    public Optional<ShopPropertyDto> shopDomainValidate(String url) {
        return shopPropertyRepository.findAll().stream()
                .filter(shop -> !url.isEmpty() && url.contains(shop.getShopDomainUrl()))
                .map(entity -> ShopPropertyDto.builder()
                        .id(entity.getId())
                        .eshopName(entity.getEshopName())
                        .shopDomainUrl(entity.getShopDomainUrl())
                        .goodsNameTag(entity.getGoodsNameTag())
                        .goodsPriceTag(entity.getGoodsPriceTag())
                        .notFoundTag(entity.getNotFoundTag())
                        .build())
                .findFirst();
    }

    @Override
    public ShopPropertyDto getShopPropertyByName(String name) {
        return shopPropertyRepository.findEShopPropertyEntityByEshopName(name)
                .map(entity -> ShopPropertyDto.builder()
                        .id(entity.getId())
                        .eshopName(entity.getEshopName())
                        .shopDomainUrl(entity.getShopDomainUrl())
                        .goodsNameTag(entity.getGoodsNameTag())
                        .goodsPriceTag(entity.getGoodsPriceTag())
                        .notFoundTag(entity.getNotFoundTag())
                        .build())
                .orElseGet(ShopPropertyDto::new);
    }
}
