package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {
    @Autowired
    ItemService itemService;

    @Test
    @Rollback(value = false)
    public void 상품추가() throws Exception {
        // given
        Item item = new Album();
        item.setName("킁");

        // when
        Long savedId = itemService.saveItem(item);

        // then
        assertEquals(item, itemService.findOne(savedId));
    }
}