package my.project.goods_parser.service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.goods_parser.model.EShopPropertyProjection;
import my.project.goods_parser.service.ShopParserService;
import my.project.goods_parser.service.UrlValidationService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Slf4j
public class ShopParserServiceImpl implements ShopParserService {

    @Override
    public boolean addToQueue(String url, EShopPropertyProjection shopPropertyProjection) {
        try {
            Document document = Jsoup.connect(url).get();
            System.out.println(document.getElementsByClass(shopPropertyProjection.getGoodsNameTag()).text());
            System.out.println(document.getElementsByClass(shopPropertyProjection.getGoodsPriceTag()).text());
            return true;
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
}
