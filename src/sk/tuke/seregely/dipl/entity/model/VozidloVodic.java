package sk.tuke.seregely.dipl.entity.model;

// Generated Mar 18, 2013 10:50:03 AM by Hibernate Tools 4.0.0

/**
 * VozidloVodic generated by hbm2java
 */
public class VozidloVodic implements java.io.Serializable {

	private VozidloVodicId id;
	private Vozidlo vozidlo;
	private Vodic vodic;

	public VozidloVodic() {
	}

	public VozidloVodic(VozidloVodicId id, Vozidlo vozidlo, Vodic vodic) {
		this.id = id;
		this.vozidlo = vozidlo;
		this.vodic = vodic;
	}

	public VozidloVodicId getId() {
		return this.id;
	}

	public void setId(VozidloVodicId id) {
		this.id = id;
	}

	public Vozidlo getVozidlo() {
		return this.vozidlo;
	}

	public void setVozidlo(Vozidlo vozidlo) {
		this.vozidlo = vozidlo;
	}

	public Vodic getVodic() {
		return this.vodic;
	}

	public void setVodic(Vodic vodic) {
		this.vodic = vodic;
	}

}
