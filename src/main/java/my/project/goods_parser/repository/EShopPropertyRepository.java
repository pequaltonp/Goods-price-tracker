package my.project.goods_parser.repository;

import my.project.goods_parser.entity.EShopPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EShopPropertyRepository extends JpaRepository<EShopPropertyEntity, Long> {
    Optional<EShopPropertyEntity> findEShopPropertyEntityByEshopName(String shopName);
}
