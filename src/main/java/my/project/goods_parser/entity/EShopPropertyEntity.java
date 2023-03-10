package my.project.goods_parser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "eshop_property")
public class EShopPropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String eshopName;
    private String shopDomainUrl;
    private String goodsNameTag;
    private String goodsPriceTag;
    private String notFoundTag;
}
