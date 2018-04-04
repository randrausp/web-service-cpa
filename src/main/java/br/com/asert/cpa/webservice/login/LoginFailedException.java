package br.com.asert.cpa.webservice.login;

public class LoginFailedException extends RuntimeException {

	public LoginFailedException(String message) {
		super(message);
	}
}
