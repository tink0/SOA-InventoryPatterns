package sk.tuke.seregely.dipl.entity.model;

// Generated Mar 18, 2013 10:50:03 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Vodic generated by hbm2java
 */
public class Vodic implements java.io.Serializable {

	private int cisloVodica;
	private Pracovisko pracovisko;
	private String celeMeno;
	private Set vozidloVodics = new HashSet(0);
	private String email;
	private Set stavJazdies = new HashSet(0);

	public Vodic() {
	}

	public Vodic(int cisloVodica, Pracovisko pracovisko) {
		this.cisloVodica = cisloVodica;
		this.pracovisko = pracovisko;
	}

	public Vodic(int cisloVodica, Pracovisko pracovisko, String celeMeno,
			Set vozidloVodics) {
		this.cisloVodica = cisloVodica;
		this.pracovisko = pracovisko;
		this.celeMeno = celeMeno;
		this.vozidloVodics = vozidloVodics;
	}

	public int getCisloVodica() {
		return this.cisloVodica;
	}

	public void setCisloVodica(int cisloVodica) {
		this.cisloVodica = cisloVodica;
	}

	public Pracovisko getPracovisko() {
		return this.pracovisko;
	}

	public void setPracovisko(Pracovisko pracovisko) {
		this.pracovisko = pracovisko;
	}

	public String getCeleMeno() {
		return this.celeMeno;
	}

	public void setCeleMeno(String celeMeno) {
		this.celeMeno = celeMeno;
	}

	public Set getVozidloVodics() {
		return this.vozidloVodics;
	}

	public void setVozidloVodics(Set vozidloVodics) {
		this.vozidloVodics = vozidloVodics;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set getStavJazdies() {
		return this.stavJazdies;
	}

	public void setStavJazdies(Set stavJazdies) {
		this.stavJazdies = stavJazdies;
	}


}
