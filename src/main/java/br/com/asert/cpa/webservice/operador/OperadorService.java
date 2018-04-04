package br.com.asert.cpa.webservice.operador;

import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperadorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperadorService.class);

	@Autowired
	private OperadorRepository operadorRepository;

	public EoperadorWebService save(EoperadorWebService op) {
		op.setDescSenha(BCrypt.hashpw(op.getDescSenha(), BCrypt.gensalt(10)));

		op.setDataInclusao(new Date());
		op.setOperadorInclusao(1);

		return operadorRepository.save(op);
	}
}
