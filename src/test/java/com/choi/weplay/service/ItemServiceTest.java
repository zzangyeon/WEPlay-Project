package com.choi.weplay.service;

import com.choi.weplay.domain.Item;
import com.choi.weplay.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    void getItem() {
        //given
        given(itemRepository.findById(1)).willReturn(new Item());
        //when
        Item item = itemService.getItem(1);

        //then
        assertNotNull(item);
    }
}