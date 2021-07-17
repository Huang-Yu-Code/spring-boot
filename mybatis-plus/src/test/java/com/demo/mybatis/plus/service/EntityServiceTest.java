package com.demo.mybatis.plus.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class EntityServiceTest {

    @Autowired
    private EntityService entityService;

    private final static int ID1 = 3;
    private final static int ID2 = 5;
    private final static BigDecimal MONEY = new BigDecimal(1000);
    private final static BigDecimal TRANSFER_MONEY = new BigDecimal(100);

    @Test
    void initial(){
        int i;
        i = entityService.initial(ID1, MONEY);
        Assertions.assertEquals(1, i);
        i = entityService.initial(ID2, MONEY);
        Assertions.assertEquals(1, i);
    }

    @Test
    void transfer() {
        entityService.transfer(ID1, ID2, TRANSFER_MONEY);
        Assertions.assertEquals(MONEY.subtract(TRANSFER_MONEY), entityService.getMoneyById(ID1));
        Assertions.assertEquals(MONEY.add(TRANSFER_MONEY), entityService.getMoneyById(ID2));
    }

    @Test
    void clear() {
        int i;
        i = entityService.clear(ID1);
        Assertions.assertEquals(1, i);
        i = entityService.clear(ID2);
        Assertions.assertEquals(1, i);
    }
}
