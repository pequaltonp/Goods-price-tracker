package my.project.goods_parser.service.impl;

import lombok.RequiredArgsConstructor;
import my.project.goods_parser.model.EShopPropertyProjection;
import my.project.goods_parser.repository.EShopPropertyRepository;
import my.project.goods_parser.service.UrlValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UrlValidationServiceImpl implements UrlValidationService {
    private final EShopPropertyRepository shopPropertyRepository;

    @Override
    public Optional<EShopPropertyProjection> shopDomainValidate(String url) {
        return shopPropertyRepository.getAllEShopProperties().stream()
                .filter(shop -> !url.isEmpty() && url.contains(shop.getShopDomainUrl()))
                .findAny();
    }
}
