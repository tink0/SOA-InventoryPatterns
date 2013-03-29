package sk.tuke.seregely.dipl.entity.model;

// Generated Mar 18, 2013 10:50:03 AM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Jazda generated by hbm2java
 */
public class Jazda implements java.io.Serializable {

	private int idJazdy;
	private Date start;
	private Date koniec;
	private BigDecimal dlzkaJazdy;
	private BigDecimal ocakavanaSpotreba;
	private Boolean sukromna;
	private String miestoStart;
	private String miestoKoniec;
	private Set suradnicas = new HashSet(0);
	private Set stavJazdies = new HashSet(0);
	private Zakazka zakazka;
	private Vodic vodic;
	private Vozidlo vozidlo;

	public Jazda() {
	}

	public Jazda(int idJazdy) {
		this.idJazdy = idJazdy;
	}

	public Jazda(int idJazdy, Date start, Date koniec, BigDecimal dlzkaJazdy,
			BigDecimal ocakavanaSpotreba, Boolean sukromna, String miestoStart,
			String miestoKoniec, Set suradnicas, Vozidlo vozidlo, Vodic vodic, Zakazka zakazka) {
		this.idJazdy = idJazdy;
		this.start = start;
		this.koniec = koniec;
		this.dlzkaJazdy = dlzkaJazdy;
		this.ocakavanaSpotreba = ocakavanaSpotreba;
		this.sukromna = sukromna;
		this.miestoStart = miestoStart;
		this.miestoKoniec = miestoKoniec;
		this.suradnicas = suradnicas;
		this.setVozidlo(vozidlo);
		this.vodic = vodic;
		this.zakazka = zakazka;
	}

	public int getIdJazdy() {
		return this.idJazdy;
	}

	public void setIdJazdy(int idJazdy) {
		this.idJazdy = idJazdy;
	}

	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getKoniec() {
		return this.koniec;
	}

	public void setKoniec(Date koniec) {
		this.koniec = koniec;
	}

	public BigDecimal getDlzkaJazdy() {
		return this.dlzkaJazdy;
	}

	public void setDlzkaJazdy(BigDecimal dlzkaJazdy) {
		this.dlzkaJazdy = dlzkaJazdy;
	}

	public BigDecimal getOcakavanaSpotreba() {
		return this.ocakavanaSpotreba;
	}

	public void setOcakavanaSpotreba(BigDecimal ocakavanaSpotreba) {
		this.ocakavanaSpotreba = ocakavanaSpotreba;
	}

	public Boolean getSukromna() {
		return this.sukromna;
	}

	public void setSukromna(Boolean sukromna) {
		this.sukromna = sukromna;
	}

	public String getMiestoStart() {
		return this.miestoStart;
	}

	public void setMiestoStart(String miestoStart) {
		this.miestoStart = miestoStart;
	}

	public String getMiestoKoniec() {
		return this.miestoKoniec;
	}

	public void setMiestoKoniec(String miestoKoniec) {
		this.miestoKoniec = miestoKoniec;
	}

	public Set getSuradnicas() {
		return this.suradnicas;
	}

	public void setSuradnicas(Set suradnicas) {
		this.suradnicas = suradnicas;
	}
	
	public Set getStavJazdies() {
		return this.stavJazdies;
	}

	public void setStavJazdies(Set stavJazdies) {
		this.stavJazdies = stavJazdies;
	}

	public Zakazka getZakazka() {
		return zakazka;
	}

	public void setZakazka(Zakazka zakazka) {
		this.zakazka = zakazka;
	}

	public Vodic getVodic() {
		return vodic;
	}

	public void setVodic(Vodic vodic) {
		this.vodic = vodic;
	}

	public Vozidlo getVozidlo() {
		return vozidlo;
	}

	public void setVozidlo(Vozidlo vozidlo) {
		this.vozidlo = vozidlo;
	}

}
