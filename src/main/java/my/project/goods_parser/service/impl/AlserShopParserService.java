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

    private final String url = "https://alser.kz";

    @Override
    public String parseByUrl(String url) {
        url = "https://alser.kz/p/garnitura-aoc-gh200-dinamiki-50-mm-35mm-razem-18m";
        try {
            Document document = Jsoup.connect(url).get();
            System.out.println(document.getElementsByClass("detail-info__name").text());
            System.out.println(document.getElementsByClass("price").text());
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
