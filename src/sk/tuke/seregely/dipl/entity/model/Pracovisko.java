package sk.tuke.seregely.dipl.entity.model;

// Generated Mar 18, 2013 10:50:03 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Pracovisko generated by hbm2java
 */
public class Pracovisko implements java.io.Serializable {

	private int idPracoviska;
	private String nazov;
	private Set veducis = new HashSet(0);
	private Set uctovniks = new HashSet(0);
	private Set vodics = new HashSet(0);

	public Pracovisko() {
	}

	public Pracovisko(int idPracoviska) {
		this.idPracoviska = idPracoviska;
	}

	public Pracovisko(int idPracoviska, String nazov, Set veducis,
			Set uctovniks, Set vodics) {
		this.idPracoviska = idPracoviska;
		this.nazov = nazov;
		this.veducis = veducis;
		this.uctovniks = uctovniks;
		this.vodics = vodics;
	}

	public int getIdPracoviska() {
		return this.idPracoviska;
	}

	public void setIdPracoviska(int idPracoviska) {
		this.idPracoviska = idPracoviska;
	}

	public String getNazov() {
		return this.nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public Set getVeducis() {
		return this.veducis;
	}

	public void setVeducis(Set veducis) {
		this.veducis = veducis;
	}

	public Set getUctovniks() {
		return this.uctovniks;
	}

	public void setUctovniks(Set uctovniks) {
		this.uctovniks = uctovniks;
	}

	public Set getVodics() {
		return this.vodics;
	}

	public void setVodics(Set vodics) {
		this.vodics = vodics;
	}

}