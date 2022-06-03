package com.choi.weplay.controller;

import com.choi.weplay.domain.Place;
import com.choi.weplay.service.PlaceService;
import com.choi.weplay.service.ReviewService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlaceController.class)
//@AutoConfigureMockMvc - MockMvc를 Builder 없이 주입 받을 수 있다.
class PlaceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlaceService placeService;

    @MockBean
    private ReviewService reviewService;

    @Test
    @DisplayName("홈-Place List 가져오기")
    void home() throws Exception {

        Place p1 = Place.builder().id(1).region("강남구").build();
        Place p2 = Place.builder().id(1).region("강남구").build();
        List<Place> placeList = new ArrayList<>();
        placeList.add(p1);
        placeList.add(p2);

        //given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
        given(placeService.getPlaceList(any())).willReturn(placeList);

        //when    mvc.perform() : api 테스트 환경을 만들어줌
        ResultActions actions = mvc.perform(get("/"));

        //then    andExpect() : 빌더 구조로 되어있어 .으로 이을 수 있다.
/*        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.region").exists();*/
        actions.andExpect(model().attribute("region","강남구"))
                .andExpect(model().attribute("places", placeList));
                //.andDo(print());

        //verify(placeService).getPlaceList("강남구");
    }

    @Test
    void homeByRegion() {
    }

    @Test
    void placeDetail() {
    }

    @Test
    void test3() throws Exception {

        //given

        //when
        mvc.perform(get("/test")).andExpect(model().attribute("test","test"));
        //then


    }

}