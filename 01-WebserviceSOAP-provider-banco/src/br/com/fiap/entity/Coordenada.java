package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_COORDENADA")
@SequenceGenerator(name="seqCoordenada", sequenceName="SQ_TB_COORDENADA", allocationSize=1)
public class Coordenada {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCoordenada")
	@Column(name="CD_COORDENADA")
	private int codigo;
	
	@Column(name="VL_LATITUDE")
	private double latidude;
	
	@Column(name="VL_LONGITUDE")
	private double longitude;
	
	@Column(name="NM_LOCAL")
	private String nomeLocal;

	public Coordenada() {
		super();
	}

	public Coordenada(double latidude, double longitude, String nomeLocal) {
		super();
		this.latidude = latidude;
		this.longitude = longitude;
		this.nomeLocal = nomeLocal;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getLatidude() {
		return latidude;
	}

	public void setLatidude(double latidude) {
		this.latidude = latidude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getNomeLocal() {
		return nomeLocal;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}
	

	
	

}
