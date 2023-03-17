package my.project.goods_parser.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.goods_parser.model.GoodsParseHistoryDto;
import my.project.goods_parser.model.GoodsParseTaskDto;
import my.project.goods_parser.model.ShopPropertyDto;
import my.project.goods_parser.service.GoodsParseHistoryService;
import my.project.goods_parser.service.GoodsParseTaskService;
import my.project.goods_parser.service.ShopPropertyService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ParseEshopTaskScheduler {
    private final ShopPropertyService shopPropertyService;
    private final GoodsParseTaskService parseTaskService;
    private final GoodsParseHistoryService goodsParseHistoryService;

    @Scheduled(fixedDelay = 2000)
    public void taskToParse() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions()
                .addArguments("headless");
        List<GoodsParseTaskDto> parseTaskDtoList = parseTaskService.getLast10NotParsedTaskByDateTime();

        parseTaskDtoList.forEach(parseTask -> {
                    try {
                        WebDriver driver = new ChromeDriver(options);
                        driver.get(parseTask.getUrl());
                        driver.manage()
                                .timeouts()
                                .implicitlyWait(Duration.ofSeconds(10));
                        ShopPropertyDto shopPropertyDto = shopPropertyService.getShopPropertyByName(parseTask.getShopName());

                        String goodsName = driver.findElement(By.cssSelector(shopPropertyDto.getGoodsNameTag())).getText();
                        String price = driver.findElement(By.cssSelector(shopPropertyDto.getGoodsPriceTag())).getText();

                        log.info(goodsName);
                        log.info(price);

                        goodsParseHistoryService.saveGoodsParseHistory(GoodsParseHistoryDto.builder()
                                        .goodsName(goodsName)
                                        .price(new BigDecimal(price))
                                        .parsedDate(LocalDate.now())
                                        .parseTaskId(parseTask.getId())
                                .build());

                        driver.quit();
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                });
    }

}
