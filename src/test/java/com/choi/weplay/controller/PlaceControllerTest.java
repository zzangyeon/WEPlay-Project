package com.choi.weplay.controller;

import com.choi.weplay.domain.Place;
import com.choi.weplay.service.PlaceService;
import com.choi.weplay.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlaceController.class)
class PlaceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlaceService placeService;

    @MockBean
    private ReviewService reviewService;


    @Test
    void home() throws Exception {

        Place place1 = new Place();
        place1.setId(1);
        Place place2 = new Place();
        place2.setId(2);
        List<Place> placeList = new ArrayList<>();
        placeList.add(place1);
        placeList.add(place2);

        //given
        //when
        ResultActions actions = mvc.perform(get("/"));
        //then
        actions.andExpect(model().attribute("region","강남구")).andExpect(model().attribute("places",placeService.getPlaceList("서초구")));


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