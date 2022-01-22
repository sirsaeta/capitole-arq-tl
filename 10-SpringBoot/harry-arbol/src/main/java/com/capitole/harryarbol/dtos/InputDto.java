package com.capitole.harryarbol.dtos;

import java.util.List;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InputDto {
	@NotNull(message = "Invalid input data")
	private List<String> listInput;
}
