package my.project.goods_parser.service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.goods_parser.model.EShopPropertyProjection;
import my.project.goods_parser.service.ShopParserService;
import my.project.goods_parser.service.UrlValidationService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Slf4j
public class ShopParserServiceImpl implements ShopParserService {

    @Override
    public boolean addToQueue(String url, EShopPropertyProjection shopPropertyProjection) {
        try {
            System.setProperty("webdriver.chrome.driver", "С:/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            System.out.println(driver.findElement(By.className(shopPropertyProjection.getGoodsNameTag())).getText());
            System.out.println(driver.findElement(By.className(shopPropertyProjection.getGoodsPriceTag())).getText());
            return true;
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
}
