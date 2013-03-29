package sk.tuke.seregely.dipl.services.entities;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Pracovisko;
import sk.tuke.seregely.dipl.entity.model.Veduci;
import sk.tuke.seregely.dipl.entity.model.Zakazka;

@WebService()
public class ZakazkaService {
	
final EntityDAO<Zakazka> zakazkaDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.Zakazka","id_zakazky");
	
	@WebMethod()
	public Zakazka retrieve(int id) {
		return zakazkaDAO.findById(id);
	}
	
	@WebMethod()
	public Zakazka create(String celeMeno, String popis, String kod) {
		Zakazka novaZakazka = new Zakazka();
		
		novaZakazka.setNazov(celeMeno);
		novaZakazka.setKod(kod);
		novaZakazka.setPopis(popis);
	
		zakazkaDAO.persist(novaZakazka);
		
		return novaZakazka;
	}
	
	@WebMethod()
	public void delete(int id) {
		Zakazka toDelete;
		toDelete = zakazkaDAO.findById(id);
		zakazkaDAO.delete(toDelete);
	}
	
	@WebMethod()
	public Zakazka update(Zakazka zakazka) {
		return zakazkaDAO.merge(zakazka);
	}

}
