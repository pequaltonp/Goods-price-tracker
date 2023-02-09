package my.project.goods_parser.service.impl;

import lombok.RequiredArgsConstructor;
import my.project.goods_parser.service.UrlValidationService;
import org.springframework.stereotype.Service;

@Service
public class UrlValidationServiceImpl implements UrlValidationService {

    @Override
    public boolean shopDomainValidate(String url) {
        String alserUrl = "https://alser.kz";
        return url.contains(alserUrl);
    }
}