package br.com.asert.cpa.webservice;

import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.asert.cpa.webservice.operador.EoperadorWebService;
import br.com.asert.cpa.webservice.operador.OperadorRepository;

@SpringBootApplication
public class WebServiceApplication implements CommandLineRunner {

	@Autowired
	private OperadorRepository operadorRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// VERIFICA SE OPERADOR ADMIN JA FOI CRIADO
		// FIND OPERADOR ADMIN POR NUMG 1 TIPO LONG
		EoperadorWebService ope = operadorRepository.findOne(1);

		if (ope == null) {
			ope = new EoperadorWebService();
			ope.setDescNome("Laboratório LQL");
			ope.setDescLogin("admin");
			ope.setDescSenha(BCrypt.hashpw("DETq8mHbd", BCrypt.gensalt(10)));
			ope.setDataInclusao(new Date());
			ope.setOperadorInclusao(1);

			operadorRepository.save(ope);
		}
	}
}
