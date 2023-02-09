package my.project.goods_parser.service;

import org.springframework.http.ResponseEntity;

public interface UrlValidationService {
    boolean shopDomainValidate(String url);
}
