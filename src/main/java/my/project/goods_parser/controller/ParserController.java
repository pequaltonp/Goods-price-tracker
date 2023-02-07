package my.project.goods_parser.controller;

import lombok.RequiredArgsConstructor;
import my.project.goods_parser.service.ShopParserService;
import my.project.goods_parser.service.impl.AlserShopParserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop-parser")
public class ParserController {
    private final ShopParserService shopParserService;

    public ParserController(ShopParserService shopParserService) {
        this.shopParserService = shopParserService;
    }

    @GetMapping("/alser")
    public String getAlser() {
        return shopParserService.parseByUrl("");
    }
}
