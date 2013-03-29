package sk.tuke.seregely.dipl.services.entities;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.entity.model.CiselnikStavov;
import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Jazda;
import sk.tuke.seregely.dipl.entity.model.StavJazdy;

@WebService()
public class StavJazdyService {
	
	final EntityDAO<StavJazdy> stavJazdyDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.StavJazdy","id_stavu_jazdy");

	@WebMethod()
	public StavJazdy retrieve(int id) {
		return stavJazdyDAO.findById(id);
	}
	
	@WebMethod()
	public StavJazdy create(CiselnikStavov ciselnikStavov, Jazda jazda, Date casZmeny, String detailZmeny) {
		StavJazdy novyStav = new StavJazdy();
		
		novyStav.setCiselnikStavov(ciselnikStavov);
		novyStav.setJazda(jazda);
		novyStav.setCasZmeny(casZmeny);
		novyStav.setDetailZmeny(detailZmeny);
		
		stavJazdyDAO.persist(novyStav);
		
		return novyStav;
	}
	
	@WebMethod()
	public void delete(int id) {
		StavJazdy toDelete;
		toDelete = stavJazdyDAO.findById(id);
		stavJazdyDAO.delete(toDelete);
	}
	
	@WebMethod()
	public StavJazdy update(StavJazdy stavJazdy) {
		return stavJazdyDAO.merge(stavJazdy);
	}
}