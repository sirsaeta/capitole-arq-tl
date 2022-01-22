package com.capitole.harryarbol.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.capitole.harryarbol.dtos.InputDto;
import com.capitole.harryarbol.dtos.ResponseDto;
import com.capitole.harryarbol.services.HarryServiceImpl;

@SpringBootTest
public class HarryControllerTest {

    @Mock
    private HarryServiceImpl harryService;

    @Spy
    @InjectMocks
    private HarryController controller;
	
	private ResponseDto sampleResponse() {
		Integer red = 0;
    	Integer black = 0;
    	List<List<Integer>> listRed = new ArrayList<>();
    	listRed.add(new ArrayList<>());
    	List<List<Integer>> listBlack = new ArrayList<>();
    	return new ResponseDto(red,listRed, black, listBlack);
	}
	
	private InputDto sampleInput() {
		List<String> arbolList = new ArrayList<>();
		arbolList.add("2");
		arbolList.add("1 2 b");
		return new InputDto(arbolList);
	}

    @Test
    void whenITryToGetTripletas() throws Exception{
        when(harryService.getTripletas(any())).thenReturn(sampleResponse());
        var result = controller.post(sampleInput());
        //then
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
