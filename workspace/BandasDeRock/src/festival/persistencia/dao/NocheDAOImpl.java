package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import festival.negocio.model.Noche;


public class NocheDAOImpl extends GenericDAOImpl<Noche, Serializable> implements NocheDAO{
	@Override
	public Noche getEntityById(Serializable id) {
		Session session = this.getSession();
		Integer idAEncontrar = null;
		try {
			idAEncontrar = (Integer) id;
		} catch (Exception e) {
			// TODO Tirar mi exception de negocio
			e.printStackTrace();
		}
		return super.findByID(Noche.class, idAEncontrar);
	}

	@Override
	public List getList() {
		return super.findAll(Noche.class);
	}

	@Override
	public List search(Map<String, Object> parameterMap) {
		//TODO ver como se hace...
		return null;
	}

	@Override
	public void update(Noche entity) {
		super.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		this.deleteById(id);
	}
	
	@Override
	public Integer save(Noche entity) {
		return (Integer) super.save(entity);
	}
}
