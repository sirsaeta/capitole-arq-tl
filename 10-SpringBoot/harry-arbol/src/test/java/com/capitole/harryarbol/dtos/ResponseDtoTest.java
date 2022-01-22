package com.capitole.harryarbol.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResponseDtoTest {

    private ResponseDto responseDto = null;
    
    @BeforeEach
    public void setup(){
    	Integer red = 4;
    	Integer black = 4;
    	List<List<Integer>> listRed = new ArrayList<>();
    	List<List<Integer>> listBlack = new ArrayList<>();
    	responseDto = new ResponseDto(red,listRed, black, listBlack);
    }

    @Test
    void whenIGetInputDto(){
        assertEquals(4, responseDto.getRed());
        assertEquals(new ArrayList<>(), responseDto.getListRed());
        assertEquals(4, responseDto.getBlack());
        assertEquals(new ArrayList<>(), responseDto.getListBlack());
    }

    @Test
    void whenIGetInputDtoWithNoArgs(){
    	var responseDto = new ResponseDto();
    	responseDto.setRed(4);
    	responseDto.setListRed(new ArrayList<>());
    	responseDto.setBlack(4);
    	responseDto.setListBlack(new ArrayList<>());
        assertEquals(4, responseDto.getRed());
        assertEquals(new ArrayList<>(), responseDto.getListRed());
        assertEquals(4, responseDto.getBlack());
        assertEquals(new ArrayList<>(), responseDto.getListBlack());
    }
}
