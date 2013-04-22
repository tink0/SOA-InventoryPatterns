package sk.tuke.seregely.dipl.services.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jws.WebService;
import javax.jws.WebMethod;

import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Jazda;
import sk.tuke.seregely.dipl.entity.model.JazdaDAO;
import sk.tuke.seregely.dipl.entity.model.SumarJazd;
import sk.tuke.seregely.dipl.entity.model.Suradnica;
import sk.tuke.seregely.dipl.entity.model.Vodic;
import sk.tuke.seregely.dipl.entity.model.Vozidlo;
import sk.tuke.seregely.dipl.entity.model.Zakazka;

@WebService()
public class JazdaService {
	
	final JazdaDAO jazdaDAO = new JazdaDAO("sk.tuke.seregely.dipl.entity.model.Jazda","id_jazdy");

	@WebMethod()
	public Jazda retrieve(int id) {
		return jazdaDAO.findById(id);
	}
	
	@WebMethod()
	public Jazda create(BigDecimal dlzkaJazdy, Date koniecCas, String miestoKoniec, String miestoStart, BigDecimal ocakavanaSpotreba, Date startCas, boolean sukromna, Vozidlo vozidlo) {
		Jazda novaJazda = new Jazda();
		
		novaJazda.setDlzkaJazdy(dlzkaJazdy);
		novaJazda.setKoniec(koniecCas);
		novaJazda.setMiestoKoniec(miestoKoniec);
		novaJazda.setMiestoStart(miestoStart);
		novaJazda.setOcakavanaSpotreba(ocakavanaSpotreba);
		novaJazda.setStart(startCas);
		novaJazda.setSukromna(sukromna);
		
		
		jazdaDAO.persist(novaJazda);
		
		return novaJazda;
	}
	
	@WebMethod()
	public void delete(int id) {
		Jazda toDelete;
		toDelete = jazdaDAO.findById(id);
		jazdaDAO.delete(toDelete);
	}
	
	@WebMethod()
	public Jazda update(Jazda jazda) {
		return jazdaDAO.merge(jazda);
	}
	
	@WebMethod()
	public SumarJazd getSum(int idVehicle, Date from, Date to) {
		List<Jazda> list = jazdaDAO.findAllForVehicle(idVehicle, from, to);
		SumarJazd sJ = new SumarJazd();
		BigDecimal sum = new BigDecimal(0);
		BigDecimal sumSpotreba = new BigDecimal(0);
		Set<Vodic> vodici = new HashSet<Vodic>(0);
		sJ.setVodici(vodici);
		Set<Zakazka> zakazky = new HashSet<Zakazka>(0);
		sJ.setZakazky(zakazky);
		
		for(Jazda j: list) {
			sum = sum.add(checkNull(j.getDlzkaJazdy()));
			sumSpotreba = sumSpotreba.add(checkNull(j.getOcakavanaSpotreba()));
			sJ.getVodici().add(j.getVodic());
			sJ.getZakazky().add(j.getZakazka());
		}
		
		sJ.setVzdialenost(sum);
		sJ.setSpotreba(sumSpotreba);
		return sJ;
	}
	
	@WebMethod()
	public List<Jazda> getListInInterval(int idVehicle, Date from, Date to) {
		List<Jazda> list = jazdaDAO.findAllForVehicle(idVehicle, from, to);
		return list;
	}
	
	public BigDecimal checkNull(BigDecimal obj) {
		if(obj == null) return new BigDecimal(0);
		return obj;
	}
	
	
	
}
