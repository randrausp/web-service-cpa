package br.com.asert.cpa.webservice.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.asert.cpa.webservice.operador.EoperadorWebService;

public class RequestFilter extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RequestFilter.class);

	private final JwtConfig jwtConfig;

	public RequestFilter(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) {

		String uri = request.getRequestURI();
		String host = request.getRemoteHost();

		logger.info("request at ${uri} from ${host}");

		String token = request.getHeader("Authorization");

		if (token == null || token.equals("")) {
			response.setStatus(403);
			logger.warn("token nao enviado: {}, uri: {}, host: {}", token, uri, host);
			return false;
		}

		EoperadorWebService operadorLogado = jwtConfig.validarTokenJwt(token);

		if (operadorLogado == null || operadorLogado.equals("")) {
			logger.warn("token invalido: {}, uri: {}, host: {}", token, uri, host);
			response.setStatus(403);
			return false;
		}

		request.getSession().setAttribute("operadorLogado", operadorLogado);

		return true;
	}
}