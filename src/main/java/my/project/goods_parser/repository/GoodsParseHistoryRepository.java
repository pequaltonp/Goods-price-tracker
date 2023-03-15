package my.project.goods_parser.repository;

import my.project.goods_parser.entity.GoodsParseHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GoodsParseHistoryRepository extends JpaRepository<GoodsParseHistoryEntity, Long> {
    List<GoodsParseHistoryEntity> findGoodsParseHistoryEntitiesByParsedDate(LocalDate parsedDate);
    List<GoodsParseHistoryEntity> findGoodsParseHistoryEntitiesByGoodsName(String name);
}
