package br.com.jopaulo.payrollapi.services;

import java.util.Objects;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.jopaulo.payrollapi.domain.Payroll;
import br.com.jopaulo.payrollapi.feingClients.UserFeign;
import br.com.jopaulo.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException.FeignClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrolService {

	private final Environment env;
	private final UserFeign feign;
	
	public Payroll getPayment(Long workId, Payroll payroll) {
		log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
		try {
			var user = feign.findById(workId).getBody();
			if (Objects.nonNull(user)) {
				return new Payroll(
						user.getName(), 
						payroll.getDescription(), 
						user.getHourlyPrice(), 
						payroll.getWorkedHours(), 
						payroll.getWorkedHours() * user.getHourlyPrice()
						);
			}
		} catch (FeignClientException e) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal argument exception");
		}
		return null;
	}
}
