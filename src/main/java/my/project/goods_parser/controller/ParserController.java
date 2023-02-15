package my.project.goods_parser.controller;

import lombok.RequiredArgsConstructor;
import my.project.goods_parser.model.EShopPropertyProjection;
import my.project.goods_parser.service.ShopParserService;
import my.project.goods_parser.service.UrlValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shop-parser")
@RequiredArgsConstructor
public class ParserController {
    private final ShopParserService shopParserService;
    private final UrlValidationService urlValidationService;

    @PostMapping("/add-to-queue")
    public ResponseEntity<String> addToQueue(@RequestParam("urlForParse") String url) {
        Optional<EShopPropertyProjection> eShopPropertyProjection = urlValidationService.shopDomainValidate(url);
        if (eShopPropertyProjection.isPresent()) {
            return shopParserService.addToQueue(url, eShopPropertyProjection.get()) ?
                    ResponseEntity.accepted().body("your request added to queue") :
                    ResponseEntity.internalServerError().body("request is not added for some reason");
        }
        else {
            return ResponseEntity.badRequest().body("e-shop is not in list");
        }
    }
}
