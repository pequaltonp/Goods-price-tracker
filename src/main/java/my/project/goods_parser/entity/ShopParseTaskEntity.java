package my.project.goods_parser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.project.goods_parser.model.GoodsParseHistoryDto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
            sequenceName = "parse_task_id_seq",
            allocationSize = 1)
    private long id;
    private String url;
    private String shopName;
    private LocalDateTime lastParseDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "shopParseTask")
    private List<GoodsParseHistoryEntity> parseHistoryEntityList = new ArrayList<>();

    public void addParseHistory(GoodsParseHistoryEntity parseHistory) {
        parseHistoryEntityList.add(parseHistory);
        parseHistory.setShopParseTask(this);
    }

    public void removeParseHistory(GoodsParseHistoryEntity parseHistory) {
        parseHistoryEntityList.remove(parseHistory);
        parseHistory.setShopParseTask(null);
    }


}
