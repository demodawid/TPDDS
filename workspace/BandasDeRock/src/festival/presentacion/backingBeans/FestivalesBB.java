package festival.presentacion.backingBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import festival.negocio.model.Festival;
import festival.negocio.model.Noche;
import festival.persistencia.dao.FestivalDAO;
import festival.persistencia.dao.FestivalDAOImpl;
import festival.persistencia.vistas.FestivalView;
import festival.persistencia.vistas.NocheView;
import festival.utils.TransformerFestivalesView;

public class FestivalesBB {
	private List<Festival> festivales;
	private List<SelectItem> festivalesItems;
	private Integer festivalSeleccionadoItem;
	private FestivalView festivalSeleccionado;
	private List<SelectItem> nochesItems;
	private Integer nocheSeleccionadaItem;
	private static final String EXITO = "exito";
	private static final String FALLO = "fallo";
	private static final String VOLVER_PRINCIPAL = "volverPrincipal";
	private static final String VOLVER_SELECCION_FESTIVAL = "volverSeleccionFestival";
	
	
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
			return FALLO;
		}
		return EXITO;
	}
	
	public String buscarNoches() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		
		Integer idFestivalSeleccionado = (Integer) this.getFestivalSeleccionadoItem();
		
		for (Festival festival : this.getFestivales()) {
			if (festival.getIdFestival().equals(idFestivalSeleccionado)) {
				this.setFestivalSeleccionado(TransformerFestivalesView.transformFestival(festival));
			}
		}
		
		for (NocheView noche : this.getFestivalSeleccionado().getNoches()) {
			SelectItem si = new SelectItem();
			si.setValue(noche.getIdNoche());
			si.setLabel("Noche " + noche.getNumero().toString());
			items.add(si);
		}
		this.setNochesItems(items);
		return EXITO;
	}
	
	/**
	 * Volver a la pagina principal
	 * @return
	 */
	public String volverPrincipal(){
		return VOLVER_PRINCIPAL;
	}
	public String volverSeleccionFestival(){
		return VOLVER_SELECCION_FESTIVAL;
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
	 * @return the nochesItems
	 */
	public List<SelectItem> getNochesItems() {
		return nochesItems;
	}

	/**
	 * @param nochesItems the nochesItems to set
	 */
	public void setNochesItems(List<SelectItem> nochesItems) {
		this.nochesItems = nochesItems;
	}

	/**
	 * @param festivalSeleccionado the festivalSeleccionado to set
	 */
	public void setFestivalSeleccionado(FestivalView festivalSeleccionado) {
		this.festivalSeleccionado = festivalSeleccionado;
	}

	/**
	 * @return the festivalSeleccionado
	 */
	public FestivalView getFestivalSeleccionado() {
		return festivalSeleccionado;
	}

	/**
	 * @return the festivalSeleccionadoItem
	 */
	public Integer getFestivalSeleccionadoItem() {
		return festivalSeleccionadoItem;
	}

	/**
	 * @param festivalSeleccionadoItem the festivalSeleccionadoItem to set
	 */
	public void setFestivalSeleccionadoItem(Integer festivalSeleccionadoItem) {
		this.festivalSeleccionadoItem = festivalSeleccionadoItem;
	}

	/**
	 * @return the nocheSeleccionadaItem
	 */
	public Integer getNocheSeleccionadaItem() {
		return nocheSeleccionadaItem;
	}

	/**
	 * @param nocheSeleccionadaItem the nocheSeleccionadaItem to set
	 */
	public void setNocheSeleccionadaItem(Integer nocheSeleccionadaItem) {
		this.nocheSeleccionadaItem = nocheSeleccionadaItem;
	}

	
	
	
}
