package my.project.goods_parser.repository;

import my.project.goods_parser.entity.ShopParseTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShopParseTaskRepository extends JpaRepository<ShopParseTaskEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM shop_parse_task " +
            "WHERE last_parse_date > localtimestamp - interval '3 hour'")
    List<ShopParseTaskEntity> findShopParseTaskEntitiesByPriority();
    List<ShopParseTaskEntity> findShopParseTaskEntitiesByShopName(String shopName);
    Optional<ShopParseTaskEntity> findShopParseTaskEntityByUrl(String url);
}
