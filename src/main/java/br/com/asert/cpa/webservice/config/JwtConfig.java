package br.com.asert.cpa.webservice.config;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.com.asert.cpa.webservice.operador.EoperadorWebService;
import br.com.asert.cpa.webservice.operador.OperadorRepository;

@Component
public class JwtConfig {

	private static final Logger logger = LoggerFactory.getLogger(JwtConfig.class);
	// ESTE HASH CORRESPONDE A SENHA "laboratoriolql_api_secret" GERADO NO SITE
	// https://passwordsgenerator.net/sha256-hash-generator/
	private static final String JWT_API_SECRET = "7ECCBBA4C0FE2B8DACA2FE202B11A74727EA4837817F169F8A190AB8523A1127";

	@Autowired
	private OperadorRepository operadorRepository;

	/**
	 *
	 * @param String
	 *            operador (subject do token JWT)
	 * @return String token JWT
	 */
	public String criarTokenJwt(EoperadorWebService op) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(JWT_API_SECRET);
			String token = JWT.create().withIssuer(op.getDescLogin()).withSubject(op.getId().toString())
					.withExpiresAt(new Date()).sign(algorithm);

			return token;
		} catch (UnsupportedEncodingException e) {
			logger.error("UTF-8 encoding not supported", e);

			return null;
		} catch (JWTCreationException e) {
			logger.error("Invalid Signing configuration / Couldn\'t convert Claims.", e);

			return null;
		}
	}

	/**
	 *
	 * @param String
	 *            token JWT
	 * @return String subject (email do operador)
	 */
	public EoperadorWebService validarTokenJwt(String tokenPrefix) throws RuntimeException {
		String token = tokenPrefix.split("Bearer ")[1];

		Algorithm algorithm;
		try {
			algorithm = Algorithm.HMAC256(JWT_API_SECRET);
		} catch (UnsupportedEncodingException e) {
			logger.error("Invalid Signing configuration / Couldn\'t convert Claims.", e);

			return null;
		}
		JWTVerifier verifier = JWT.require(algorithm).acceptExpiresAt(60 * 60 * 24).build();

		DecodedJWT jwt = verifier.verify(token);

		EoperadorWebService operador = operadorRepository.findOneByDescLoginAndDataExclusaoIsNull(jwt.getSubject());

		if (Objects.isNull(operador)) {
			return null;
		}

		return operador;
	}
}