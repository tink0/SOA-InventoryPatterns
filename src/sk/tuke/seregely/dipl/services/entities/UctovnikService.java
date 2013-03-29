package sk.tuke.seregely.dipl.services.entities;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Pracovisko;
import sk.tuke.seregely.dipl.entity.model.Uctovnik;

@WebService()
public class UctovnikService {
	
	final EntityDAO<Uctovnik> uctovnikDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.Uctovnik","id_uctovnika");

@WebMethod()
public Uctovnik retrieve(int id) {
	return uctovnikDAO.findById(id);
}

@WebMethod()
public Uctovnik create(String celeMeno, Pracovisko pracovisko, String email) {
	Uctovnik novyUctovnik = new Uctovnik();

	novyUctovnik.setCeleMeno(celeMeno);
	novyUctovnik.setPracovisko(pracovisko);
	novyUctovnik.setEmail(email);

	uctovnikDAO.persist(novyUctovnik);
	
	return novyUctovnik;
}

@WebMethod()
public void delete(int id) {
	Uctovnik toDelete;
	toDelete = uctovnikDAO.findById(id);
	uctovnikDAO.delete(toDelete);
}

@WebMethod()
public Uctovnik update(Uctovnik uctovnik) {
	return uctovnikDAO.merge(uctovnik);
}

}
