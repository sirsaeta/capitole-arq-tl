package com.capitole.harryarbol.services;

import com.capitole.harryarbol.dtos.InputDto;
import com.capitole.harryarbol.dtos.ResponseDto;

public interface HarryService {
	ResponseDto getTripletas(InputDto input) throws Exception;
}
