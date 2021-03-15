package com.cruzeirodosul.cielo.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAGTRN")
public class Transacao implements Serializable {
	private static final long serialVersionUID = -2629423900801999053L;
	
	@Id
	@GeneratedValue
	private Long idTrn;
	private String tid;
	private Integer locPgto;
	private Date dtTrn;
	private String trnModal;
	private Integer trnTotPar;
	private BigDecimal trnValTot;
	private String trnProduto;
	private String trnNome;
	private Integer codEmpr;
	private Integer codInst;
	private Integer trnCodban;

	public Transacao() {}

	public Long getIdTrn() {
		return idTrn;
	}

	public void setIdTrn(Long idTrn) {
		this.idTrn = idTrn;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Integer getLocPgto() {
		return locPgto;
	}

	public void setLocPgto(Integer locPgto) {
		this.locPgto = locPgto;
	}

	public Date getDtTrn() {
		return dtTrn;
	}

	public void setDtTrn(Date dtTrn) {
		this.dtTrn = dtTrn;
	}

	public String getTrnModal() {
		return trnModal;
	}

	public void setTrnModal(String trnModal) {
		this.trnModal = trnModal;
	}

	public Integer getTrnTotPar() {
		return trnTotPar;
	}

	public void setTrnTotPar(Integer trnTotPar) {
		this.trnTotPar = trnTotPar;
	}

	public BigDecimal getTrnValTot() {
		return trnValTot;
	}

	public void setTrnValTot(BigDecimal trnValTot) {
		this.trnValTot = trnValTot;
	}

	public String getTrnProduto() {
		return trnProduto;
	}

	public void setTrnProduto(String trnProduto) {
		this.trnProduto = trnProduto;
	}

	public String getTrnNome() {
		return trnNome;
	}

	public void setTrnNome(String trnNome) {
		this.trnNome = trnNome;
	}

	public Integer getCodEmpr() {
		return codEmpr;
	}

	public void setCodEmpr(Integer codEmpr) {
		this.codEmpr = codEmpr;
	}

	public Integer getCodInst() {
		return codInst;
	}

	public void setCodInst(Integer codInst) {
		this.codInst = codInst;
	}

	public Integer getTrnCodban() {
		return trnCodban;
	}

	public void setTrnCodban(Integer trnCodban) {
		this.trnCodban = trnCodban;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEmpr == null) ? 0 : codEmpr.hashCode());
		result = prime * result + ((codInst == null) ? 0 : codInst.hashCode());
		result = prime * result + ((dtTrn == null) ? 0 : dtTrn.hashCode());
		result = prime * result + ((idTrn == null) ? 0 : idTrn.hashCode());
		result = prime * result + ((locPgto == null) ? 0 : locPgto.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + ((trnCodban == null) ? 0 : trnCodban.hashCode());
		result = prime * result + ((trnModal == null) ? 0 : trnModal.hashCode());
		result = prime * result + ((trnNome == null) ? 0 : trnNome.hashCode());
		result = prime * result + ((trnProduto == null) ? 0 : trnProduto.hashCode());
		result = prime * result + ((trnTotPar == null) ? 0 : trnTotPar.hashCode());
		result = prime * result + ((trnValTot == null) ? 0 : trnValTot.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		if (codEmpr == null) {
			if (other.codEmpr != null)
				return false;
		} else if (!codEmpr.equals(other.codEmpr))
			return false;
		if (codInst == null) {
			if (other.codInst != null)
				return false;
		} else if (!codInst.equals(other.codInst))
			return false;
		if (dtTrn == null) {
			if (other.dtTrn != null)
				return false;
		} else if (!dtTrn.equals(other.dtTrn))
			return false;
		if (idTrn == null) {
			if (other.idTrn != null)
				return false;
		} else if (!idTrn.equals(other.idTrn))
			return false;
		if (locPgto == null) {
			if (other.locPgto != null)
				return false;
		} else if (!locPgto.equals(other.locPgto))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (trnCodban == null) {
			if (other.trnCodban != null)
				return false;
		} else if (!trnCodban.equals(other.trnCodban))
			return false;
		if (trnModal == null) {
			if (other.trnModal != null)
				return false;
		} else if (!trnModal.equals(other.trnModal))
			return false;
		if (trnNome == null) {
			if (other.trnNome != null)
				return false;
		} else if (!trnNome.equals(other.trnNome))
			return false;
		if (trnProduto == null) {
			if (other.trnProduto != null)
				return false;
		} else if (!trnProduto.equals(other.trnProduto))
			return false;
		if (trnTotPar == null) {
			if (other.trnTotPar != null)
				return false;
		} else if (!trnTotPar.equals(other.trnTotPar))
			return false;
		if (trnValTot == null) {
			if (other.trnValTot != null)
				return false;
		} else if (!trnValTot.equals(other.trnValTot))
			return false;
		return true;
	}
}
