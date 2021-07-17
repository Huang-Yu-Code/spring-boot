package com.demo.mybatis.plus.service;

import com.demo.mybatis.plus.entity.Entity;
import com.demo.mybatis.plus.mapper.EntityMapper;
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
        return entityMapper.insert(entity);
    }

    public BigDecimal getMoneyById(int id){
        return entityMapper.selectById(id).getMoney();
    }

    @Transactional(rollbackFor = Exception.class)
    public void transfer(int id1, int id2, BigDecimal money) {
        Entity entity1 = entityMapper.selectById(id1);
        Entity entity2 = entityMapper.selectById(id2);
        entity1.setMoney(entity1.getMoney().subtract(money));
        entityMapper.updateById(entity1);
        if (id2 == 4) {
            throw new RuntimeException("转账异常");
        }
        entity2.setMoney(entity2.getMoney().add(money));
        entityMapper.updateById(entity2);
    }

    @Transactional(rollbackFor = Exception.class)
    public int clear(int id){
        return entityMapper.deleteById(id);
    }
}
