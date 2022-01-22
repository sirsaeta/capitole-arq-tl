package com.capitole.harryarbol.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.capitole.harryarbol.dtos.InputDto;
import com.capitole.harryarbol.dtos.ResponseDto;

@SpringBootTest
public class HarryServiceTest {

	@Spy
    @InjectMocks
    private HarryServiceImpl harryService = new HarryServiceImpl();
	
	private ResponseDto sampleResponse() {
		Integer red = 0;
    	Integer black = 0;
    	List<List<Integer>> listRed = new ArrayList<>();
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
        //given
        var expected = sampleResponse();
        
        var result  = harryService.getTripletas(sampleInput());
        //then
        assertEquals(expected.getBlack(),result.getBlack());
        assertEquals(expected.getRed(),result.getRed());
        assertEquals(expected.getListBlack().size(),result.getListBlack().size());
        assertEquals(expected.getListRed().size(),result.getListRed().size());
    }

}
