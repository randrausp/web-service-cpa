package br.com.asert.cpa.webservice.utils;

import java.util.Collection;

import org.springframework.boot.SpringApplication;

import br.com.asert.cpa.webservice.WebServiceApplication;

public class Utilitario {
	/**
	 * Verifica se uma lista contem elementos e se esta instanciada.
	 * 
	 * @param lista
	 *            Objeto java.util.List a ser verificado.
	 * @return Retorna true se nÃƒÂ£o estiver instanciada ou nÃƒÂ£o tiver
	 *         elementos, caso contrÃƒÂ¡rio, retornarÃƒÂ¡ false.
	 */
	public static boolean listaVazia(Collection lista) {

		if (lista == null)
			return true;

		return (lista.size() == 0);
	}

	/**
	 * Verifica se uma String contÃƒÂ©m caracteres e se estÃƒÂ¡ instanciada
	 * 
	 * @param s
	 *            String a ser verificada
	 * @return Retorna true se nÃƒÂ£o estiver instanciada ou nÃƒÂ£o tiver
	 *         caracteres, caso contrÃƒÂ¡rio, retornarÃƒÂ¡ false.
	 */
	public static boolean StringNullOuVazia(String s) {
		if (s == null) {
			return true;
		} else {
			return (s.length() == 0);
		}
	}

	/**
	 * Verifica se uma String contem caracteres e se esta instanciada Passando
	 * um trim na mesma.
	 * 
	 * @param s
	 *            String a ser verificada
	 * @return Retorna true se nÃƒÂ£o estiver instanciada ou nÃƒÂ£o tiver
	 *         caracteres, caso contrÃƒÂ¡rio, retornarÃƒÂ¡ false.
	 */
	public static boolean StringNullOuVaziaComTrim(String s) {
		if (s == null) {
			return true;
		} else {
			return (s.trim().length() == 0);
		}
	}

	/**
	 * Verifica se um Integer estÃƒÂ¡ instanciado e se seu valor ÃƒÂ© igual a
	 * zero.
	 * 
	 * @param i
	 *            Integer a ser verificado
	 * @return Retorna true se nÃƒÂ£o estiver instanciada ou se seu valor ÃƒÂ©
	 *         igual a zero, caso contrÃƒÂ¡rio, retornarÃƒÂ¡ false.
	 */
	public static boolean IntegerNullOuZero(Integer i) {
		if (i == null) {
			return true;
		} else {
			return (i.intValue() == 0);
		}
	}

	/**
	 * Verifica se um Integer esta instanciado e se seu valor e maior que zero.
	 * 
	 * @param i
	 *            Integer a ser verificado
	 * @return Retorna true se nao estiver instanciada ou se seu valor for menor
	 *         igual a zero, caso contrario, retornara false.
	 */
	public static boolean IntegerNullOuMenorZero(Integer i) {
		if (i == null) {
			return true;
		} else {
			return (i.intValue() <= 0);
		}
	}

	/**
	 * Verifica se uma Objeto convertido pra String esta nulo ou vazio
	 * 
	 * @param o
	 *            Objeto a ser convertido para String e verificado
	 * @return Retorna true se não estiver instanciada ou não tiver caracteres,
	 *         caso contrário, retornará false.
	 */
	public static boolean ObjetoParaStringNullOuVaziaComTrim(Object o) {
		if (o == null) {
			return true;
		} else {
			return (o.toString().trim().length() == 0);
		}
	}
}