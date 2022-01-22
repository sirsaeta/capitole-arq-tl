package com.capitole.harryarbol.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InputDtoTest {

    private InputDto inputDto = null;
    
    @BeforeEach
    public void setup(){
    	List<String> arbolList = new ArrayList<>();
    	inputDto = new InputDto(arbolList);
    }

    @Test
    void whenIGetInputDto(){
        assertEquals(new ArrayList<>(), inputDto.getListInput());
    }

    @Test
    void whenIGetInputDtoWithNoArgs(){
    	var inputDto = new InputDto();
    	inputDto.setListInput(new ArrayList<>());
        assertEquals(new ArrayList<>(), inputDto.getListInput());
    }
}
