package sk.tuke.seregely.dipl.entity.model;

// Generated Mar 18, 2013 10:50:03 AM by Hibernate Tools 4.0.0

/**
 * VozidloVodicId generated by hbm2java
 */
public class VozidloVodicId implements java.io.Serializable {

	private int cisloVodica;
	private int idVozidla;

	public VozidloVodicId() {
	}

	public VozidloVodicId(int cisloVodica, int idVozidla) {
		this.cisloVodica = cisloVodica;
		this.idVozidla = idVozidla;
	}

	public int getCisloVodica() {
		return this.cisloVodica;
	}

	public void setCisloVodica(int cisloVodica) {
		this.cisloVodica = cisloVodica;
	}

	public int getIdVozidla() {
		return this.idVozidla;
	}

	public void setIdVozidla(int idVozidla) {
		this.idVozidla = idVozidla;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VozidloVodicId))
			return false;
		VozidloVodicId castOther = (VozidloVodicId) other;

		return (this.getCisloVodica() == castOther.getCisloVodica())
				&& (this.getIdVozidla() == castOther.getIdVozidla());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCisloVodica();
		result = 37 * result + this.getIdVozidla();
		return result;
	}

}
