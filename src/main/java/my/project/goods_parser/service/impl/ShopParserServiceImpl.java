package my.project.goods_parser.service.impl;

import lombok.extern.slf4j.Slf4j;
import my.project.goods_parser.model.EShopPropertyProjection;
import my.project.goods_parser.service.ShopParserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
public class ShopParserServiceImpl implements ShopParserService {

    @Override
    public boolean addToQueue(String url, EShopPropertyProjection shopPropertyProjection) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions()
                .addArguments("headless");
        try {
            WebDriver driver = new ChromeDriver(options);
            driver.get(url);
            driver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

            System.out.println(driver.findElement(By.cssSelector(shopPropertyProjection.getGoodsNameTag())).getText());
            System.out.println(driver.findElement(By.cssSelector(shopPropertyProjection.getGoodsPriceTag())).getText());
            driver.quit();
            return true;
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
}
