package festival.presentacion.backingBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import festival.negocio.model.Festival;
import festival.persistencia.dao.FestivalDAO;
import festival.persistencia.dao.FestivalDAOImpl;

public class FestivalesBB {
	private List<Festival> festivales;
	private List<SelectItem> festivalesItems;
	
	private SelectItem festivalSeleccionado;
	
	
	
	/**
	 * Busca todos los festivales
	 */
	public String buscarFestivales(){
		try {
			FestivalDAO festivalDAO = new FestivalDAOImpl();
			this.setFestivales(festivalDAO.getList());
			
			List<SelectItem> items = new ArrayList<SelectItem>();
			for (Festival festival : this.getFestivales()) {
				SelectItem si = new SelectItem();
				si.setValue(festival.getIdFestival());
				si.setLabel(festival.getNombre());
				items.add(si);
			}
			this.setFestivalesItems(items);
			
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
	 * @return the festivalesItems
	 */
	public List<SelectItem> getFestivalesItems() {
		return festivalesItems;
	}

	/**
	 * @param festivalesItems the festivalesItems to set
	 */
	public void setFestivalesItems(List<SelectItem> festivalesItems) {
		this.festivalesItems = festivalesItems;
	}

	/**
	 * @return the festivalSeleccionado
	 */
	public SelectItem getFestivalSeleccionado() {
		return festivalSeleccionado;
	}

	/**
	 * @param festivalSeleccionado the festivalSeleccionado to set
	 */
	public void setFestivalSeleccionado(SelectItem festivalSeleccionado) {
		this.festivalSeleccionado = festivalSeleccionado;
	}



	
	
}
