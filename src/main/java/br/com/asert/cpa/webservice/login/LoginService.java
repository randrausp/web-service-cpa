package br.com.asert.cpa.webservice.login;

import java.util.HashMap;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.asert.cpa.webservice.config.JwtConfig;
import br.com.asert.cpa.webservice.operador.EoperadorWebService;
import br.com.asert.cpa.webservice.operador.OperadorRepository;
import br.com.asert.cpa.webservice.utils.Utilitario;

@Component
public class LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	private final OperadorRepository operadorRepository;
	private final JwtConfig jwtConfig;

	LoginService(OperadorRepository operadorRepository, JwtConfig jwtConfig) {
		this.operadorRepository = operadorRepository;
		this.jwtConfig = jwtConfig;
	}

	public Map<String, Object> validarCredenciais(String descLogin, String descSenha) {

		EoperadorWebService operador = operadorRepository.findOneByDescLoginAndDataExclusaoIsNull(descLogin);

		if (operador == null || operador.equals("")) {
			logger.warn("operador e/ou senha nao encontrados");
			throw new LoginFailedException("Operador e/ou senha não encontrados.");
		}

		if (!BCrypt.checkpw(descSenha, operador.getDescSenha())) {
			logger.warn("operador e/ou senha nao encontrados");
			throw new LoginFailedException("Operador e/ou senha não encontrados.");
		}

		String token = jwtConfig.criarTokenJwt(operador);

		if (Utilitario.StringNullOuVaziaComTrim(token)) {
			logger.warn("nao foi possivel gerar token de validacao");
			throw new LoginFailedException("Não foi possível gerar token jwt.");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("operador", operador);
		map.put("token", token);

		return map;
	}
}