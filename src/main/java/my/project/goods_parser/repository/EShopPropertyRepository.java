package my.project.goods_parser.repository;

import my.project.goods_parser.entity.EShopPropertyEntity;
import my.project.goods_parser.model.EShopPropertyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EShopPropertyRepository extends JpaRepository<EShopPropertyEntity, Long> {

    @Query(nativeQuery = true,
            value = "SELECT e.shop_domain_url shopDomainUrl, \n" +
                    "      e.goods_name_tag goodsNameTag, \n" +
                    "      e.goods_price_tag goodsPriceTag,\n" +
                    "      e.not_found_tag notFoundTag FROM eshop_price_tracker_db.public.eshop_property e")
    List<EShopPropertyProjection> getAllEShopProperties();
}
