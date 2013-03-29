package sk.tuke.seregely.dipl.entity.model;

// Generated Mar 18, 2013 10:50:03 AM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Suradnica generated by hbm2java
 */
public class Suradnica implements java.io.Serializable {

	private float x;
	private Jazda jazda;
	private Integer idSuradnice;
	private float y;
	private Float presnost;
	private Date cas;
	private Float rychlost;

	public Suradnica() {
	}

	public Suradnica(float x, float y, Date cas) {
		this.x = x;
		this.y = y;
		this.cas = cas;
	}

	public Suradnica(float x, Jazda jazda, Integer idSuradnice, float y,
			Float presnost, Date cas) {
		this.x = x;
		this.jazda = jazda;
		this.idSuradnice = idSuradnice;
		this.y = y;
		this.presnost = presnost;
		this.cas = cas;
	}

	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public Jazda getJazda() {
		return this.jazda;
	}

	public void setJazda(Jazda jazda) {
		this.jazda = jazda;
	}

	public Integer getIdSuradnice() {
		return this.idSuradnice;
	}

	public void setIdSuradnice(Integer idSuradnice) {
		this.idSuradnice = idSuradnice;
	}

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Float getPresnost() {
		return this.presnost;
	}

	public void setPresnost(Float presnost) {
		this.presnost = presnost;
	}

	public Date getCas() {
		return this.cas;
	}

	public void setCas(Date cas) {
		this.cas = cas;
	}
	
	public Float getRychlost() {
		return this.rychlost;
	}
	
	public void setRychlost(Float rychlost) {
		this.rychlost = rychlost;
	}

}