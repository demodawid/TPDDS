package festival.presentacion.backingBeans;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import festival.negocio.model.Entrada;
import festival.negocio.model.Festival;
import festival.negocio.model.Noche;
import festival.persistencia.dao.EntradaDAO;
import festival.persistencia.dao.EntradaDAOImpl;
import festival.presentacion.vistas.EntradaView;
import festival.presentacion.vistas.FestivalView;
import festival.presentacion.vistas.NocheView;
import festival.utils.ConstantesFestival;
import festival.utils.TransformerEntradasView;
import festival.utils.TransformerFestivalesView;
import festival.utils.TransformerNochesView;

public class RetornoEntradasBB {
	private Date fechaDeHoy;
	private String mensajeDeError;
	private Integer idEntradaARetornar;
	private Entrada entradaARetornarEntity;
	private EntradaView entradaARetornar;
	private FestivalView festivalDeLaEntradaARetornar;
	private NocheView nocheDeLaEntradaARetornar;
	private BigDecimal cantidadADevolver;
	private BigDecimal precioOriginalPagado;
	
	public RetornoEntradasBB() {
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
	
	public String verEntradaADevolver () {
		try {
			EntradaDAO entradaDAO = new EntradaDAOImpl();
			Entrada entradaEntity = entradaDAO.getEntityById(this.getIdEntradaARetornar());
			this.setEntradaARetornarEntity(entradaEntity);
			this.setEntradaARetornar(TransformerEntradasView.transormEntrada(entradaEntity));
			
			if (this.getEntradaARetornar() == null) {
				this.setMensajeDeError("La entrada es inexistente");
				return ConstantesFestival.FALLO;
			}
			
			Noche nocheEntity = entradaEntity.getButaca().getNoche();
			Festival festivalEntity = entradaEntity.getButaca().getNoche().getFestival();
			
			this.setFestivalDeLaEntradaARetornar(TransformerFestivalesView.transformFestival(festivalEntity));
			this.setNocheDeLaEntradaARetornar(TransformerNochesView.transformNoche(nocheEntity));
		} catch (Exception e) {
			this.setMensajeDeError("Error en la comunicacion con la base de datos");
			return ConstantesFestival.FALLO;
		}
		return ConstantesFestival.EXITO;
	}
	
	public String retornarEntrada() {
		
		BigDecimal retornoDinero;
		
		if (this.getEntradaARetornarEntity().getAnticipada()) {
			if (this.getFechaDeHoy().after(this.getNocheDeLaEntradaARetornar().getFechaFinAnticipada())) {
				this.setMensajeDeError("No puede retornar una entrada anticipada luego de la fecha final");
				return ConstantesFestival.FALLO;
			}
		} else {
			if (this.getFechaDeHoy().after(this.getNocheDeLaEntradaARetornar().getFecha())) {
				this.setMensajeDeError("No puede retornar una entrada despues de la noche");
				return ConstantesFestival.FALLO;	
			}
		}
		
		retornoDinero = this.getEntradaARetornarEntity().getPrecioFinal()
				.multiply(BigDecimal.valueOf(this.getEntradaARetornarEntity().getButaca().getNoche().getDevolucion()))
				.divide(new BigDecimal(100));
		
		this.setPrecioOriginalPagado(new BigDecimal(this.getEntradaARetornar().getPrecioFinal()));
		
		try {
			EntradaDAO entradaDAO = new EntradaDAOImpl();
			entradaDAO.delete(this.getEntradaARetornarEntity());
		} catch (Exception e) {
			this.setMensajeDeError("Error interno en la base de datos");
			return ConstantesFestival.FALLO;
		}

		this.setCantidadADevolver(retornoDinero);
		
		return ConstantesFestival.EXITO;
	}
	
	public String iniciarRetornoEntrada(){
		this.setEntradaARetornar(null);
		this.setIdEntradaARetornar(null);
		this.setMensajeDeError(null);
		return "retornarEntrada";
	}
	
	/**
	 * @return the idEntradaARetornar
	 */
	public Integer getIdEntradaARetornar() {
		return idEntradaARetornar;
	}

	/**
	 * @param idEntradaARetornar the idEntradaARetornar to set
	 */
	public void setIdEntradaARetornar(Integer idEntradaARetornar) {
		this.idEntradaARetornar = idEntradaARetornar;
	}

	/**
	 * @return the entradaARetornar
	 */
	public EntradaView getEntradaARetornar() {
		return entradaARetornar;
	}

	/**
	 * @param entradaARetornar the entradaARetornar to set
	 */
	public void setEntradaARetornar(EntradaView entradaARetornar) {
		this.entradaARetornar = entradaARetornar;
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
	 * @return the festivalDeLaEntradaARetornar
	 */
	public FestivalView getFestivalDeLaEntradaARetornar() {
		return festivalDeLaEntradaARetornar;
	}

	/**
	 * @param festivalDeLaEntradaARetornar the festivalDeLaEntradaARetornar to set
	 */
	public void setFestivalDeLaEntradaARetornar(
			FestivalView festivalDeLaEntradaARetornar) {
		this.festivalDeLaEntradaARetornar = festivalDeLaEntradaARetornar;
	}

	/**
	 * @return the nocheDeLaEntradaARetornar
	 */
	public NocheView getNocheDeLaEntradaARetornar() {
		return nocheDeLaEntradaARetornar;
	}

	/**
	 * @param nocheDeLaEntradaARetornar the nocheDeLaEntradaARetornar to set
	 */
	public void setNocheDeLaEntradaARetornar(NocheView nocheDeLaEntradaARetornar) {
		this.nocheDeLaEntradaARetornar = nocheDeLaEntradaARetornar;
	}

	/**
	 * @return the entradaARetornarEntity
	 */
	public Entrada getEntradaARetornarEntity() {
		return entradaARetornarEntity;
	}

	/**
	 * @param entradaARetornarEntity the entradaARetornarEntity to set
	 */
	public void setEntradaARetornarEntity(Entrada entradaARetornarEntity) {
		this.entradaARetornarEntity = entradaARetornarEntity;
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
	 * @return the cantidadADevolver
	 */
	public BigDecimal getCantidadADevolver() {
		return cantidadADevolver;
	}

	/**
	 * @param cantidadADevolver the cantidadADevolver to set
	 */
	public void setCantidadADevolver(BigDecimal cantidadADevolver) {
		this.cantidadADevolver = cantidadADevolver;
	}

	/**
	 * @return the precioOriginalPagado
	 */
	public BigDecimal getPrecioOriginalPagado() {
		return precioOriginalPagado;
	}

	/**
	 * @param precioOriginalPagado the precioOriginalPagado to set
	 */
	public void setPrecioOriginalPagado(BigDecimal precioOriginalPagado) {
		this.precioOriginalPagado = precioOriginalPagado;
	}
	
}
