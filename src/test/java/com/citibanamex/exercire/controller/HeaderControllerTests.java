package com.citibanamex.exercire.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HeaderControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnAllHeaders() throws Exception {

        String expect = "{\"Accept\":[\"application/json\"],\"Content-Type\":[\"application/json;charset=UTF-8\"]}";

        mvc.perform( get( "/v1/header" )
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString( expect )
                ));
    }

    @Test
    public void shouldReturnAcceptHeader() throws Exception {

        String expect = "{\"Accept\":[\"application/json\"]}";

        mvc.perform( get( "/v1/header/filter?headerNames=Accept" )
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString( expect )
                ));
    }

    @Test
    public void shouldReturnContentTypeHeader() throws Exception {

        String expect = "{\"Content-Type\":[\"application/json;charset=UTF-8\"]}";

        mvc.perform( get( "/v1/header/filter?headerNames=Content-Type" )
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString( expect )
                ));
    }

    @Test
    public void shouldReturnContentTypeAndAcceptHeaders() throws Exception {

        String expect = "{\"Accept\":[\"application/json\"],\"Content-Type\":[\"application/json;charset=UTF-8\"]}";

        mvc.perform( get( "/v1/header/filter?headerNames=Content-Type,Accept" )
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString( expect )
                ));
    }

}
