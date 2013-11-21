package festival.presentacion.backingBeans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import festival.negocio.model.Butaca;
import festival.negocio.model.Entrada;
import festival.negocio.model.Festival;
import festival.negocio.model.Noche;
import festival.persistencia.dao.ButacaDAO;
import festival.persistencia.dao.ButacaDAOImpl;
import festival.persistencia.dao.EntradaDAO;
import festival.persistencia.dao.EntradaDAOImpl;
import festival.persistencia.dao.FestivalDAO;
import festival.persistencia.dao.FestivalDAOImpl;
import festival.persistencia.vistas.ButacaView;
import festival.persistencia.vistas.FestivalView;
import festival.persistencia.vistas.NocheView;
import festival.utils.ConstantesFestival;
import festival.utils.TransformerFestivalesView;

public class FestivalesBB {
	private List<Festival> festivales;
	private List<SelectItem> festivalesItems;
	private Integer festivalSeleccionadoItem;
	private FestivalView festivalSeleccionado;
	private List<SelectItem> nochesItems;
	private Integer nocheSeleccionadaItem;
	private NocheView nocheSeleccionada;
	private Integer idButacaSeleccionada;
	private ButacaView butacaSeleccionada;
	private Integer idEntradaComprada;
	private Boolean esEntradaAnticipada;
	private String mensajeDeError;
	private Date fechaDeHoy;
	
	public FestivalesBB() {
		Properties prop = new Properties();
		try {
			//Cargo la fecha de hoy del archivo de configuracion
			prop.load(new FileInputStream("config.properties"));
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			
			this.setFechaDeHoy(sdf.parse(prop.getProperty("fechaHoy")));

		} catch (Exception e) {
			//Si falla, por defecto uso la fecha de sistema
			this.setFechaDeHoy(new Date());
		}
	}
	
	/**
	 * Busca todos los festivales
	 */
	public String buscarFestivales(){
		this.setButacaSeleccionada(null);
		this.setEsEntradaAnticipada(null);
		this.setFestivales(null);
		this.setFestivalesItems(null);
		this.setFestivalSeleccionado(null);
		this.setFestivalSeleccionadoItem(null);
		this.setIdButacaSeleccionada(null);
		this.setIdEntradaComprada(null);
		this.setMensajeDeError(null);
		this.setNocheSeleccionada(null);
		this.setNocheSeleccionadaItem(null);
		this.setNochesItems(null);
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
			this.setMensajeDeError("Error de base de datos");
			return ConstantesFestival.FALLO;
		}
		return ConstantesFestival.EXITO;
	}
	
	public String buscarNoches() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		
		for (Festival festival : this.getFestivales()) {
			if (festival.getIdFestival().equals(this.getFestivalSeleccionadoItem())) {
				this.setFestivalSeleccionado(TransformerFestivalesView.transformFestival(festival));
				break;
			}
		}
		
		for (NocheView noche : this.getFestivalSeleccionado().getNoches()) {
			SelectItem si = new SelectItem();
			si.setValue(noche.getIdNoche());
			si.setLabel("Noche " + noche.getNumero().toString());
			items.add(si);
		}
		this.setNochesItems(items);
		return ConstantesFestival.EXITO;
	}
	
	public String buscarEntrada() {
		for (NocheView nocheView : this.getFestivalSeleccionado().getNoches()) {
			if (this.getNocheSeleccionadaItem().equals(nocheView.getIdNoche())) {
				this.setNocheSeleccionada(nocheView);
				break;
			}
		}
		return ConstantesFestival.EXITO;
	}
	
	public String armarCompraEntrada() {
		for (ButacaView butacaView: this.getNocheSeleccionada().getButacas()) {
			if (butacaView.getIdButaca().equals(this.getIdButacaSeleccionada())) {
				this.setButacaSeleccionada(butacaView);
				break;
			}
		}
		return ConstantesFestival.EXITO;
	}
	public String comprarEntrada() {
		ButacaDAO butacaDAO = new ButacaDAOImpl();
		try {
			//Creo la nueva entidad entrada
			Entrada entrada = new Entrada();
			
			entrada.setAnticipada(this.getEsEntradaAnticipada());
			entrada.setFechaVenta(this.getFechaDeHoy());
			
			if (this.getEsEntradaAnticipada()) {
				entrada.setPrecioFinal(new BigDecimal(this.butacaSeleccionada.getPrecioConDescuento()));
			} else {
				entrada.setPrecioFinal(this.butacaSeleccionada.getPrecioBase());
			}
			
			Butaca butaca = butacaDAO.getEntityById(idButacaSeleccionada);
			entrada.setButaca(butaca);

			EntradaDAO entradaDAO = new EntradaDAOImpl();
			Integer id = entradaDAO.save(entrada);
			
			this.setIdEntradaComprada(id);
			
		} catch (Exception e) {
			return ConstantesFestival.FALLO;
		}
		return ConstantesFestival.EXITO;
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

	/**
	 * @return the esEntradaAnticipada
	 */
	public Boolean getEsEntradaAnticipada() {
		return esEntradaAnticipada;
	}

	/**
	 * @param esEntradaAnticipada the esEntradaAnticipada to set
	 */
	public void setEsEntradaAnticipada(Boolean esEntradaAnticipada) {
		this.esEntradaAnticipada = esEntradaAnticipada;
	}

	/**
	 * @return the nocheSeleccionada
	 */
	public NocheView getNocheSeleccionada() {
		return nocheSeleccionada;
	}

	/**
	 * @param nocheSeleccionada the nocheSeleccionada to set
	 */
	public void setNocheSeleccionada(NocheView nocheSeleccionada) {
		this.nocheSeleccionada = nocheSeleccionada;
	}

	/**
	 * @return the butacaSeleccionada
	 */
	public ButacaView getButacaSeleccionada() {
		return butacaSeleccionada;
	}

	/**
	 * @param butacaSeleccionada the butacaSeleccionada to set
	 */
	public void setButacaSeleccionada(ButacaView butacaSeleccionada) {
		this.butacaSeleccionada = butacaSeleccionada;
	}

	/**
	 * @return the idButacaSeleccionada
	 */
	public Integer getIdButacaSeleccionada() {
		return idButacaSeleccionada;
	}

	/**
	 * @param idButacaSeleccionada the idButacaSeleccionada to set
	 */
	public void setIdButacaSeleccionada(Integer idButacaSeleccionada) {
		this.idButacaSeleccionada = idButacaSeleccionada;
	}

	/**
	 * @return the mensajeDeError
	 */
	public String getMensajeDeError() {
		return mensajeDeError;
	}

	/**
	 * @param mensajeDeError the mensajeDeError to set
	 */
	public void setMensajeDeError(String mensajeDeError) {
		this.mensajeDeError = mensajeDeError;
	}

	/**
	 * @return the fechaDeHoy
	 */
	public Date getFechaDeHoy() {
		return fechaDeHoy;
	}

	/**
	 * @param fechaDeHoy the fechaDeHoy to set
	 */
	public void setFechaDeHoy(Date fechaDeHoy) {
		this.fechaDeHoy = fechaDeHoy;
	}

	/**
	 * @return the idEntradaComprada
	 */
	public Integer getIdEntradaComprada() {
		return idEntradaComprada;
	}

	/**
	 * @param idEntradaComprada the idEntradaComprada to set
	 */
	public void setIdEntradaComprada(Integer idEntradaComprada) {
		this.idEntradaComprada = idEntradaComprada;
	}
	
}
