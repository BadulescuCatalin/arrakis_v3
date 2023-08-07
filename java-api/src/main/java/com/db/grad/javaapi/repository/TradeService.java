package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TradeService {

    @Autowired
    TradeRepository tradeRepository;

    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }
    public List<Trade> getTradeByBookId(List<Integer> ids) {
        List<Trade> trades = new ArrayList<>();
        for(int id : ids) {
            trades.addAll(tradeRepository.findByBookId(id));
        }
        return trades;
    }
}
