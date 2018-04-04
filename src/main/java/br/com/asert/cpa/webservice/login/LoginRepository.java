package br.com.asert.cpa.webservice.login;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.asert.cpa.webservice.exception.padrao.DatabaseException;
import br.com.asert.cpa.webservice.utils.Utilitario;

@Repository
public class LoginRepository {

	private static final Logger logger = LoggerFactory.getLogger(LoginRepository.class);

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public HashMap<String, Object> buscarUsuarioPorLogin(String descLogin) {

		// abre session com o banco
		EntityManager session = entityManagerFactory.createEntityManager();

		try {

			StringBuilder sql = new StringBuilder("");
			sql.append("SELECT \n");
			sql.append("	desc_Login, desc_Senha \n");
			sql.append("FROM \n");
			sql.append("	seg_operadoreswebservice \n");
			sql.append("WHERE \n");
			sql.append("	desc_Login LIKE '").append(descLogin).append("';");

			List<Object[]> result = session.createNativeQuery(sql.toString()).getResultList();

			if (Utilitario.listaVazia(result))
				return null;

			HashMap<String, Object> map = new HashMap<>();
			map.put("descLogin", result.get(0)[1]);
			map.put("descSenha", result.get(0)[2]);

			return map;
		} catch (Exception e) {
			logger.error("nao foi possivel buscar as credenciais", e);
			throw new DatabaseException("Não foi possível buscar as credenciais.");
		} finally {
			if (session.isOpen())
				session.close();
		}
	}
}