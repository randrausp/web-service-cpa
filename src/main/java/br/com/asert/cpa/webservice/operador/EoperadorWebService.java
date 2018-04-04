package br.com.asert.cpa.webservice.operador;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "seg_operadoreswebservice")
public class EoperadorWebService {

	@Id
	@Column(name = "numg_operador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 70)
	@Column(name = "desc_nome")
	private String descNome;

	@NotNull
	@NotEmpty
	@Size(min = 6, max = 50)
	@Column(name = "desc_login", unique = true)
	private String descLogin;

	@NotNull
	@NotEmpty
	@Size(min = 6, max = 60)
	@Column(name = "desc_senha", unique = true)
	private String descSenha;

	@NotNull
	@NotEmpty
	@Column(name = "numg_operadorinclusao")
	private Integer operadorInclusao;

	@NotNull
	@NotEmpty
	@Column(name = "data_inclusao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao;

	@Column(name = "numg_operadorexclusao")
	private Integer operadorExclusao;

	@Column(name = "data_exclusao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataExclusao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescNome() {
		return descNome;
	}

	public void setDescNome(String descNome) {
		this.descNome = descNome;
	}

	public String getDescLogin() {
		return descLogin;
	}

	public void setDescLogin(String descLogin) {
		this.descLogin = descLogin;
	}

	public String getDescSenha() {
		return descSenha;
	}

	public void setDescSenha(String descSenha) {
		this.descSenha = descSenha;
	}

	public Integer getOperadorInclusao() {
		return operadorInclusao;
	}

	public void setOperadorInclusao(Integer operadorInclusao) {
		this.operadorInclusao = operadorInclusao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Integer getOperadorExclusao() {
		return operadorExclusao;
	}

	public void setOperadorExclusao(Integer operadorExclusao) {
		this.operadorExclusao = operadorExclusao;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}
}
