package br.com.asert.cpa.webservice.exception.padrao;

public class DatabaseException extends RuntimeException {

	public DatabaseException(String message) {
		super(message);
	}
}
