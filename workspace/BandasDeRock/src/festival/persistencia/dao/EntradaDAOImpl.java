package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import festival.negocio.model.Entrada;

public class EntradaDAOImpl extends GenericDAOImpl<Entrada, Serializable> implements EntradaDAO {
	@Override
	public Entrada getEntityById(Serializable id) {
		Integer idAEncontrar = null;
		try {
			idAEncontrar = (Integer) id;
		} catch (Exception e) {
			// TODO Tirar mi exception de negocio
			e.printStackTrace();
		}
		return super.findByID(Entrada.class, idAEncontrar);
	}

	@Override
	public List getList() {
		return super.findAll(Entrada.class);
	}

	@Override
	public List search(Map<String, Object> parameterMap) {
		//TODO ver como se hace...
		return null;
	}

	@Override
	public void update(Entrada entity) {
		super.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		this.deleteById(id);
	}
	
	@Override
	public Integer save (Entrada entity){
		return (Integer) super.save(entity);
	}
}
