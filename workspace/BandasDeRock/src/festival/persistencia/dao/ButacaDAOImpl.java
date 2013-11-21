package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import festival.negocio.model.Butaca;

public class ButacaDAOImpl extends GenericDAOImpl<Butaca, Serializable> implements ButacaDAO{

	@Override
	public Butaca getEntityById(Serializable id) {
		Session session = this.getSession();
		Integer idAEncontrar = null;
		try {
			idAEncontrar = (Integer) id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.findByID(Butaca.class, idAEncontrar);
	}

	@Override
	public List getList() {
		return super.findAll(Butaca.class);
	}

	@Override
	public List search(Map<String, Object> parameterMap) {
		//TODO ver como se hace...
		return null;
	}

	@Override
	public void update(Butaca entity) {
		super.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		this.deleteById(id);
	}
	
	@Override
	public Integer save (Butaca entity){
		return (Integer) super.save(entity);
	}
}
