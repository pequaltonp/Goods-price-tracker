package my.project.goods_parser.scheduler;

import lombok.RequiredArgsConstructor;
import my.project.goods_parser.service.ShopParserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

@RequiredArgsConstructor
public class ParseEshopTaskScheduler {
    private final ShopParserService shopParserService;

    @Scheduled()
    public void taskToParse() {

    }

}
