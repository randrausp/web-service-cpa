package br.com.asert.cpa.webservice.login;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private final LoginService loginService;

	LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping
	ResponseEntity login(@RequestBody Map<String, String> body) {
		if (!body.containsKey("descLogin") || !body.containsKey("descSenha") || body.get("descLogin") == null
				|| body.get("descSenha") == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		try {
			Map<String, Object> result = loginService.validarCredenciais(body.get("descLogin"), body.get("descSenha"));
			LOGGER.info("login realizado com sucesso.");
			return new ResponseEntity(result, HttpStatus.OK);
		} catch (LoginFailedException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
		} catch (Exception any) {
			LOGGER.error("nao foi possivel realizar login. {}", any);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}