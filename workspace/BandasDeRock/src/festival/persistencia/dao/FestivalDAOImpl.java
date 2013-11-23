package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import festival.negocio.model.Festival;

public class FestivalDAOImpl extends GenericDAOImpl<Festival, Serializable> implements FestivalDAO {
	@Override
	public Festival getEntityById(Serializable id) {
		Integer idAEncontrar = null;
		try {
			idAEncontrar = (Integer) id;
		} catch (Exception e) {
			// TODO Tirar mi exception de negocio
			e.printStackTrace();
		}
		return super.findByID(Festival.class, idAEncontrar);
	}

	@Override
	public List getList() {
		return super.findAll(Festival.class);
	}

	@Override
	public List search(Map<String, Object> parameterMap) {
		//TODO ver como se hace...
		return null;
	}

	@Override
	public void update(Festival entity) {
		super.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		this.deleteById(id);
	}
	
	@Override
	public Integer save (Festival entity){
		return (Integer) super.save(entity);
	}
}
