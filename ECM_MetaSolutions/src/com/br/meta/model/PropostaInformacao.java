package com.br.meta.model;

public class PropostaInformacao {

	private String beneficiario;

	private String numeroProposta;

	private String cpfCnpf;

	private String inicioVigencia;

	private String fimVigencia;

	private boolean reapresentacaoSimN�o;

	/**
	 * @return the beneficiario
	 */
	public String getBeneficiario() {
		return beneficiario;
	}

	/**
	 * @param beneficiario
	 *            the beneficiario to set
	 */
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	/**
	 * @return the numeroProposta
	 */
	public String getNumeroProposta() {
		return numeroProposta;
	}

	/**
	 * @param numeroProposta
	 *            the numeroProposta to set
	 */
	public void setNumeroProposta(String numeroProposta) {
		this.numeroProposta = numeroProposta;
	}

	/**
	 * @return the cpfCnpf
	 */
	public String getCpfCnpf() {
		return cpfCnpf;
	}

	/**
	 * @param cpfCnpf
	 *            the cpfCnpf to set
	 */
	public void setCpfCnpf(String cpfCnpf) {
		this.cpfCnpf = cpfCnpf;
	}

	/**
	 * @return the inicioVigencia
	 */
	public String getInicioVigencia() {
		return inicioVigencia;
	}

	/**
	 * @param inicioVigencia
	 *            the inicioVigencia to set
	 */
	public void setInicioVigencia(String inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	/**
	 * @return the fimVigencia
	 */
	public String getFimVigencia() {
		return fimVigencia;
	}

	/**
	 * @param fimVigencia
	 *            the fimVigencia to set
	 */
	public void setFimVigencia(String fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	/**
	 * @return the reapresentacaoSimN�o
	 */
	public boolean isReapresentacaoSimN�o() {
		return reapresentacaoSimN�o;
	}

	/**
	 * @param reapresentacaoSimN�o
	 *            the reapresentacaoSimN�o to set
	 */
	public void setReapresentacaoSimN�o(boolean reapresentacaoSimN�o) {
		this.reapresentacaoSimN�o = reapresentacaoSimN�o;
	}

}
