package my.project.goods_parser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shop_parse_task")
public class ShopParseTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "parse_task_generator")
    @SequenceGenerator(name = "parse_task_generator",
            sequenceName = "parse_task_id_seq")
    private long id;
    private String url;
    private String shopName;
    private LocalDateTime lastParseDate;
}
