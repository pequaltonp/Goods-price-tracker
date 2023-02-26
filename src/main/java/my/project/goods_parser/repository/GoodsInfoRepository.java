package my.project.goods_parser.repository;

import my.project.goods_parser.entity.GoodsInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsInfoRepository extends JpaRepository<GoodsInfoEntity, Long> {
    List<GoodsInfoEntity> findGoodsInfoEntitiesByUrl(String url);
    List<GoodsInfoEntity> findGoodsInfoEntitiesByGoodsName(String name);
}
