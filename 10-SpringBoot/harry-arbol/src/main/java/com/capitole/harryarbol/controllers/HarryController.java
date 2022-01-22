package com.capitole.harryarbol.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.harryarbol.dtos.InputDto;
import com.capitole.harryarbol.dtos.ResponseDto;
import com.capitole.harryarbol.services.HarryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="")
@AllArgsConstructor
public class HarryController {
	
	@Autowired
	private HarryService service;

    @PostMapping("")
    public ResponseEntity<ResponseDto> post(@Valid @RequestBody final InputDto input) throws Exception{
    	var response = service.getTripletas(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

}
