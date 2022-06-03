package com.choi.weplay.service;

import com.choi.weplay.domain.Item;
import com.choi.weplay.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

//1. @SpringBootTest(classes = {ItemRepository.class, ItemService.class} )
//2. @ExtendWith(SpringExtension.class)
//2. @Import({ItemRepository.class, ItemService.class})
//3.
@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock//@MockBean
    private ItemRepository itemRepository;

    @InjectMocks//@Autowired
    private ItemService itemService;

    @Test
    void getItem() {
        //given
        given(itemRepository.findById(1)).willReturn(new Item(1,"아이템1"));

        //when
        Item item = itemService.getItem(1);

        //then
        assertEquals(item.getId(),1);
        assertEquals(item.getName(),"아이템1");
    }
}