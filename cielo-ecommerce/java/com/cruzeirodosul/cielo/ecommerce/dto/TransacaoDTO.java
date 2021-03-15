package com.cruzeirodosul.cielo.ecommerce.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class TransacaoDTO implements Serializable {
	private static final long serialVersionUID = -4553678878054411415L;
	private Long lojCreden;
	private String lojLogo;
	private String lojNome;
	private String lojChave;
	private String mid;
	private String sExitCapt;
	private String sExitPgto;
	private String sCodErro;
	private String sMensagem;
	
	public Long getLojCreden() {
		return lojCreden;
	}

	public void setLojCreden(Long lojCreden) {
		this.lojCreden = lojCreden;
	}

	public String getLojLogo() {
		return lojLogo;
	}

	public void setLojLogo(String lojLogo) {
		this.lojLogo = lojLogo;
	}

	public String getLojNome() {
		return lojNome;
	}

	public void setLojNome(String lojNome) {
		this.lojNome = lojNome;
	}

	public String getLojChave() {
		return lojChave;
	}

	public void setLojChave(String lojChave) {
		this.lojChave = lojChave;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getsExitCapt() {
		return sExitCapt;
	}

	public void setsExitCapt(String sExitCapt) {
		this.sExitCapt = sExitCapt;
	}

	public String getsExitPgto() {
		return sExitPgto;
	}

	public void setsExitPgto(String sExitPgto) {
		this.sExitPgto = sExitPgto;
	}

	public String getsCodErro() {
		return sCodErro;
	}

	public void setsCodErro(String sCodErro) {
		this.sCodErro = sCodErro;
	}

	public String getsMensagem() {
		return sMensagem;
	}

	public void setsMensagem(String sMensagem) {
		this.sMensagem = sMensagem;
	}	

	@Override
	public String toString() {
		return "TransacaoDTO [lojCreden=" + lojCreden + ", lojLogo=" + lojLogo + ", lojNome=" + lojNome + ", lojChave="
				+ lojChave + ", mid=" + mid + ", sExitCapt=" + sExitCapt + ", sExitPgto=" + sExitPgto + ", sCodErro="
				+ sCodErro + ", sMensagem=" + sMensagem + "]";
	}
}
