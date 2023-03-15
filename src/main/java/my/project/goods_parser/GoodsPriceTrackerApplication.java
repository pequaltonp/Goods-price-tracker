package my.project.goods_parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GoodsPriceTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsPriceTrackerApplication.class, args);
    }

}
