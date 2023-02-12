package my.project.goods_parser.service.impl;

import lombok.RequiredArgsConstructor;
import my.project.goods_parser.service.UrlValidationService;
import org.springframework.stereotype.Service;

@Service
public class UrlValidationServiceImpl implements UrlValidationService {

    @Override
    public boolean shopDomainValidate(String url) {
        String alserUrl = "https://alser.kz";
        String technodomUrl = "https://www.technodom.kz";
        String evrikaUrl = "https://evrika.com";
        String mechtaUrl = "https://www.mechta.kz";
        String whiteVeterUrl = "https://shop.kz/";
        String dnsUrl = "https://www.dns-shop.kz/";
        return url.contains(alserUrl);
    }
}
