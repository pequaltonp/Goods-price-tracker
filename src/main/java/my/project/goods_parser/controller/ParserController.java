package my.project.goods_parser.controller;

import lombok.RequiredArgsConstructor;
import my.project.goods_parser.model.GoodsParseHistoryDto;
import my.project.goods_parser.model.GoodsParseTaskDto;
import my.project.goods_parser.model.ShopPropertyDto;
import my.project.goods_parser.service.GoodsParseTaskService;
import my.project.goods_parser.service.ShopParserService;
import my.project.goods_parser.service.ShopPropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/shop-parser")
@RequiredArgsConstructor
public class ParserController {
    private final ShopParserService shopParserService;
    private final ShopPropertyService shopPropertyService;
    private final GoodsParseTaskService parseTaskService;

    @PostMapping("/add-to-queue")
    public ResponseEntity<String> addToQueue(@RequestParam("urlForParse") String url) {
        Optional<ShopPropertyDto> shopProperty = shopPropertyService.shopDomainValidate(url);
        if (shopProperty.isPresent())
            return parseTaskService.addToQueue(GoodsParseTaskDto.builder()
                            .lastParseDate(LocalDateTime.of(2023, 3, 1, 12, 0))
                            .shopName(shopProperty.get().getEshopName())
                            .url(url)
                    .build()) ?
                    ResponseEntity.accepted().body("your request added to queue") :
                    ResponseEntity.internalServerError().body("request is not added for some reason");
        else
            return ResponseEntity.badRequest().body("e-shop is not in list");
    }
}
