package br.com.jopaulo.payrollapi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jopaulo.payrollapi.domain.Payroll;
import br.com.jopaulo.payrollapi.domain.User;
import br.com.jopaulo.payrollapi.feingClients.UserFeign;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {
	
	private final UserFeign userFeign;

	@GetMapping(value = "/{workId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workId, @RequestBody Payroll payment) {		
		User user = userFeign.findById(workId).getBody();
		
		return ResponseEntity.ok().body(
				new Payroll(
						user.getName(), 
						payment.getDescription(), 
						user.getHourlyPrice(), 
						payment.getWorkedHours(),
						user.getHourlyPrice() * payment.getWorkedHours())
				);
	}

}
