package my.project.goods_parser.controller;

import lombok.RequiredArgsConstructor;
import my.project.goods_parser.model.ShopPropertyDto;
import my.project.goods_parser.service.ShopParserService;
import my.project.goods_parser.service.ShopPropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shop-parser")
@RequiredArgsConstructor
public class ParserController {
    private final ShopParserService shopParserService;
    private final ShopPropertyService shopPropertyService;

    @PostMapping("/add-to-queue")
    public ResponseEntity<String> addToQueue(@RequestParam("urlForParse") String url) {
        Optional<ShopPropertyDto> eShopPropertyProjection = shopPropertyService.shopDomainValidate(url);
        if (eShopPropertyProjection.isPresent()) {
            return shopParserService.parseShop(url, eShopPropertyProjection.get()) ?
                    ResponseEntity.accepted().body("your request added to queue") :
                    ResponseEntity.internalServerError().body("request is not added for some reason");
        }
        else {
            return ResponseEntity.badRequest().body("e-shop is not in list");
        }
    }
}
