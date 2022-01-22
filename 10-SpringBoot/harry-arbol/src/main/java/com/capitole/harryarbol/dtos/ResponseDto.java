package com.capitole.harryarbol.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
	private Integer red;
	private List<List<Integer>> listRed;
	private Integer black;
	private List<List<Integer>> listBlack;
}
