package my.project.goods_parser.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = "shopParseTask")
@Table(name = "goods_parse_history")
public class GoodsParseHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "parse_history_generator")
    @SequenceGenerator(name = "parse_history_generator",
            sequenceName = "goods_info_pk_id_seq",
            allocationSize = 1)
    private long id;
    private String goodsName;
    private BigDecimal price;
    private LocalDate parsedDate;
    @ManyToOne
    @JoinColumn(name = "parse_task_id")
    private ShopParseTaskEntity shopParseTask;

}
