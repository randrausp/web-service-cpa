package br.com.asert.cpa.webservice.operador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorRepository extends JpaRepository<EoperadorWebService, Integer> {

	public EoperadorWebService findOneByDescLogin(String descLogin);

	public EoperadorWebService findOneByDescLoginAndDataExclusaoIsNull(String descLogin);
}