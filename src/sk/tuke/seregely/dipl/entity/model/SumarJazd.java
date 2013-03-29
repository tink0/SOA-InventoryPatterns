package sk.tuke.seregely.dipl.entity.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class SumarJazd {
	
	private BigDecimal vzdialenost;
	private Date obdobieOd;
	private Date obdovieDo;
	private BigDecimal spotreba;
	private Set<Vodic> vodici;
	private Set<Zakazka> zakazky;
	
	public BigDecimal getVzdialenost() {
		return vzdialenost;
	}
	public void setVzdialenost(BigDecimal vzdialenost) {
		this.vzdialenost = vzdialenost;
	}
	public Date getObdobieOd() {
		return obdobieOd;
	}
	public void setObdobieOd(Date obdobieOd) {
		this.obdobieOd = obdobieOd;
	}
	public Date getObdovieDo() {
		return obdovieDo;
	}
	public void setObdovieDo(Date obdovieDo) {
		this.obdovieDo = obdovieDo;
	}
	public BigDecimal getSpotreba() {
		return spotreba;
	}
	public void setSpotreba(BigDecimal spotreba) {
		this.spotreba = spotreba;
	}
	public Set<Vodic> getVodici() {
		return vodici;
	}
	public void setVodici(Set<Vodic> vodici) {
		this.vodici = vodici;
	}
	public Set<Zakazka> getZakazky() {
		return zakazky;
	}
	public void setZakazky(Set<Zakazka> zakazky) {
		this.zakazky = zakazky;
	}

}
