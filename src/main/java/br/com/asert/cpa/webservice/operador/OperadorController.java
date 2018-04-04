package br.com.asert.cpa.webservice.operador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.asert.cpa.webservice.config.RequestFilter;

@RestController
@RequestMapping("/operadores")
public class OperadorController {

	private final static Logger LOGGER = LoggerFactory.getLogger(OperadorController.class);

	private final HttpServletRequest request;
	private final HttpServletResponse response;

	@Autowired
	private OperadorService operadorService;

	public OperadorController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	@GetMapping
	ResponseEntity getAll(@RequestBody EoperadorWebService operador) {
		return null;
	}

	@PostMapping
	ResponseEntity save(@RequestBody EoperadorWebService eoperador) {

		RequestFilter req = new RequestFilter(jwtConfig);
		
		Boolean b = req.preHandle(request, response, eoperador);

		EoperadorWebService result = operadorService.save(eoperador);

		LOGGER.info("salvo com sucesso.");
		return new ResponseEntity(result, HttpStatus.CREATED);
	}

	// @PostMapping
	// ResponseEntity post(@Valid @RequestBody EoperadorWebService eoperador, Errors
	// errors) {
	// if (errors.hasErrors()) {
	// return new ResponseEntity(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
	// }
	//
	// try {
	// UsuarioEntity usuarioSessao = request.getSession().getAttribute("usuario") as
	// UsuarioEntity;
	// ProfissionalEntity result = profissionalService.create(profissionalEntity,
	// usuarioSessao)
	//
	// logger.info('profissional criado com sucesso.')
	//
	// return new ResponseEntity(result, HttpStatus.CREATED)
	// } catch (ContraintException e) {
	// return new ResponseEntity([error: true, message: e.message],
	// HttpStatus.PRECONDITION_FAILED)
	// } catch (DatabaseException e) {
	// return new ResponseEntity([error: true, message: e.message],
	// HttpStatus.INTERNAL_SERVER_ERROR)
	// }
	// }

}