package my.project.goods_parser.service;


import my.project.goods_parser.model.EShopPropertyProjection;

import java.util.Optional;

public interface UrlValidationService {
    Optional<EShopPropertyProjection> shopDomainValidate(String url);
}
