package br.com.asert.cpa.webservice.requisicao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RiquisicaoController {

	@GetMapping("/requisicao")
	public ResponseEntity get(@RequestParam(required = false, value = "token") String token) {
		return new ResponseEntity(token, HttpStatus.OK);
	}
}