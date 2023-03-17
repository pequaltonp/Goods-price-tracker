package my.project.goods_parser.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShopPropertyDto {
    private long id;
    private String eshopName;
    private String shopDomainUrl;
    private String goodsNameTag;
    private String goodsPriceTag;
    private String notFoundTag;
}
