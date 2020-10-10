package br.com.alura.forum.config.validation;

public class ErrorValidationFormDTO {

	private String mensagem;
	private String erro;

	public ErrorValidationFormDTO(String mensagem, String erro) {
		super();
		this.mensagem = mensagem;
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getErro() {
		return erro;
	}

}
