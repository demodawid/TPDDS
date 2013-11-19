package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import festival.negocio.model.Banda;

public class BandaDaoImpl extends GenericDAOImpl<Banda, Serializable> implements BandaDao{

	@Override
	public Banda getEntityById(Serializable id) {
		Session session = this.getSession();
		Integer idAEncontrar = null;
		try {
			idAEncontrar = (Integer) id;
		} catch (Exception e) {
			// TODO Tirar mi exception de negocio
			e.printStackTrace();
		}
		super.findByID(Banda.class, idAEncontrar);
		return null;
	}

	@Override
	public List getList() {
		return super.findAll(Banda.class);
	}

	@Override
	public List search(Map<String, Object> parameterMap) {
		//TODO ver como se hace...
		return null;
	}

	@Override
	public void update(Banda entity) {
		super.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		this.deleteById(id);
	}

}
