package com.demo.mybatis.service;

import com.demo.mybatis.entity.Entity;
import com.demo.mybatis.mapper.EntityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author codingob
 */
@Service
public class EntityService {

    @Resource
    private EntityMapper entityMapper;

    @Transactional(rollbackFor = Exception.class)
    public int initial(int id, BigDecimal money){
        Entity entity = new Entity();
        entity.setId(id);
        entity.setName("entity"+ id);
        entity.setGender(false);
        entity.setMoney(money);
        return entityMapper.create(entity);
    }

    public BigDecimal getMoneyById(int id){
        return entityMapper.getById(id).getMoney();
    }

    @Transactional(rollbackFor = Exception.class)
    public void transfer(int id1, int id2, BigDecimal money) {
        Entity entity1 = entityMapper.getById(id1);
        Entity entity2 = entityMapper.getById(id2);
        entity1.setMoney(entity1.getMoney().subtract(money));
        entityMapper.update(entity1);
        if (id2 == 4) {
            throw new RuntimeException("转账异常");
        }
        entity2.setMoney(entity2.getMoney().add(money));
        entityMapper.update(entity2);
    }

    @Transactional(rollbackFor = Exception.class)
    public int clear(int id){
        return entityMapper.deleteById(id);
    }
}
