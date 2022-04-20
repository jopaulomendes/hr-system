package br.com.jopaulo.payrollapi.resources.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StandarError {

	private LocalDateTime timestamp;
	private String error;
	private Integer status;
	private String path;
}
