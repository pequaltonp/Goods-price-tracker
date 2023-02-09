package my.project.goods_parser.service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.goods_parser.service.ShopParserService;
import my.project.goods_parser.service.UrlValidationService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Slf4j
public class AlserShopParserService implements ShopParserService {

    @Override
    public boolean parseByUrl(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            System.out.println(document.getElementsByClass("detail-info__name").text());
            System.out.println(document.getElementsByClass("price").text());
            return true;
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;

    }
}
