package my.project.goods_parser.service;

import org.springframework.http.ResponseEntity;

public interface UrlValidationService {
    ResponseEntity<String> shopDomainValidate(String url);
}
