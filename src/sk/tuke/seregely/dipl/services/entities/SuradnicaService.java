package sk.tuke.seregely.dipl.services.entities;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Jazda;
import sk.tuke.seregely.dipl.entity.model.Suradnica;

@WebService()
public class SuradnicaService {

final EntityDAO<Suradnica> suradnicaDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.Suradnica","id_suradnice");
	
	@WebMethod()
	public Suradnica retrieve(int id) {
		return suradnicaDAO.findById(id);
	}
	
	@WebMethod()
	public Suradnica create(Date cas, Jazda jazda, Float presnost, Float x, Float y, Float rychlost) {
		Suradnica novaSuradnica = new Suradnica();
		
		novaSuradnica.setCas(cas);
		novaSuradnica.setJazda(jazda);
		novaSuradnica.setPresnost(presnost);
		novaSuradnica.setX(x);
		novaSuradnica.setY(y);
		novaSuradnica.setRychlost(rychlost);
	
		suradnicaDAO.persist(novaSuradnica);
		
		return novaSuradnica;
	}
	
	@WebMethod()
	public void delete(int id) {
		Suradnica toDelete;
		toDelete = suradnicaDAO.findById(id);
		suradnicaDAO.delete(toDelete);
	}
	
	@WebMethod()
	public Suradnica update(Suradnica suradnica) {
		return suradnicaDAO.merge(suradnica);
	}

}

