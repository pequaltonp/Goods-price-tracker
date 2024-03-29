package my.project.goods_parser.repository;

import my.project.goods_parser.entity.GoodsParseHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsParseHistoryRepository extends JpaRepository<GoodsParseHistoryEntity, Long> {
    List<GoodsParseHistoryEntity> findGoodsParseHistoryEntitiesByParsedDateTime(LocalDateTime parsedDate);
    List<GoodsParseHistoryEntity> findGoodsParseHistoryEntitiesByGoodsName(String name);
    Optional<GoodsParseHistoryEntity> findGoodsParseHistoryEntitiesById(long id);
}
