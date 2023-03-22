package my.project.goods_parser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "goods_parse_history")
public class GoodsParseHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "parse_history_generator")
    @SequenceGenerator(name = "parse_history_generator",
            sequenceName = "eshop_price_tracker_db.public.goods_info_pk_id_seq",
            allocationSize = 1)
    private long id;
    private String goodsName;
    private BigDecimal price;
    private LocalDate parsedDate;
    private long parseTaskId;

}
