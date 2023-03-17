package my.project.goods_parser.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsParseTaskDto {
    private long id;
    private String url;
    private String shopName;
    private LocalDateTime lastParseDate;
}
