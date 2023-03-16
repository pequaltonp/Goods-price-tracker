package my.project.goods_parser.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsParseHistoryDto {
    private long id;
    private String goodsName;
    private BigDecimal price;
    private LocalDate parsedDate;
}
