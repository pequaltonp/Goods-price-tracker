package my.project.goods_parser.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.goods_parser.model.GoodsParseTaskDto;
import my.project.goods_parser.model.ShopPropertyDto;
import my.project.goods_parser.repository.EShopPropertyRepository;
import my.project.goods_parser.service.GoodsParseTaskService;
import my.project.goods_parser.service.ShopParserService;
import my.project.goods_parser.service.ShopPropertyService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import java.time.Duration;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ParseEshopTaskScheduler {
    private final ShopParserService shopParserService;
    private final ShopPropertyService shopPropertyService;
    private final GoodsParseTaskService parseTaskService;

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
                        log.info(driver.findElement(By.cssSelector(shopPropertyDto.getGoodsNameTag())).getText());
                        log.info(driver.findElement(By.cssSelector(shopPropertyDto.getGoodsPriceTag())).getText());
                        driver.quit();
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                });


    }

}
