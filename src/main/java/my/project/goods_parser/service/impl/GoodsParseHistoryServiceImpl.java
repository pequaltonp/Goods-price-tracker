package my.project.goods_parser.service.impl;

import lombok.RequiredArgsConstructor;
import my.project.goods_parser.repository.GoodsParseHistoryRepository;
import my.project.goods_parser.service.GoodsParseHistoryService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GoodsParseHistoryServiceImpl implements GoodsParseHistoryService {
    private final GoodsParseHistoryRepository parseHistoryRepository;

    @Override
    public void saveGoodsInfo() {

    }

    @Override
    public void updateGoodsInfo() {

    }
}
