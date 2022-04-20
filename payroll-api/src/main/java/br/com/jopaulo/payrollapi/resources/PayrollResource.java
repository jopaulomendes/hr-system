package br.com.jopaulo.payrollapi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jopaulo.payrollapi.domain.Payroll;
import br.com.jopaulo.payrollapi.services.PayrolService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {
	
	private final PayrolService service;
	
	@GetMapping(value = "/{workId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workId, @RequestBody Payroll payment) {		
		return ResponseEntity.ok().body(service.getPayment(workId, payment));
	}

}
