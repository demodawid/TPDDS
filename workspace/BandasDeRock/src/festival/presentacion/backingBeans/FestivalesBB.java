package festival.presentacion.backingBeans;

import java.util.List;

import festival.negocio.model.Festival;
import festival.persistencia.dao.FestivalDAO;
import festival.persistencia.dao.FestivalDAOImpl;

public class FestivalesBB {
	private List<Festival> festivales;
	
	private Integer idFestivalSeleccionado;
	
	
	
	/**
	 * Busca todos los festivales
	 */
	public String buscarFestivales(){
		try {
			FestivalDAO festivalDAO = new FestivalDAOImpl();
			this.setFestivales(festivalDAO.getList());
		} catch (Exception e) {
			return "fallo";
		}
		return "exito";
	}

	/**
	 * @return the festivales
	 */
	public List<Festival> getFestivales() {
		return festivales;
	}

	/**
	 * @param festivales the festivales to set
	 */
	public void setFestivales(List<Festival> festivales) {
		this.festivales = festivales;
	}

	/**
	 * @return the idFestivalSeleccionado
	 */
	public Integer getIdFestivalSeleccionado() {
		return idFestivalSeleccionado;
	}

	/**
	 * @param idFestivalSeleccionado the idFestivalSeleccionado to set
	 */
	public void setIdFestivalSeleccionado(Integer idFestivalSeleccionado) {
		this.idFestivalSeleccionado = idFestivalSeleccionado;
	}
	
	
	
}
