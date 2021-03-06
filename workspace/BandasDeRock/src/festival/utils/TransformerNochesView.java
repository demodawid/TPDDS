package festival.utils;

import java.util.ArrayList;
import java.util.List;

import festival.negocio.model.Banda;
import festival.negocio.model.Butaca;
import festival.negocio.model.Noche;
import festival.presentacion.vistas.BandaView;
import festival.presentacion.vistas.ButacaView;
import festival.presentacion.vistas.NocheView;

public class TransformerNochesView {
	public static NocheView transformNoche(Noche noche){
		NocheView nocheView = new NocheView();
		
		List<ButacaView> butacasView = new ArrayList<ButacaView>();

		for (Butaca butaca : noche.getButacas()) {
			ButacaView butacaView = TransformerButacasView.transformButaca(butaca, noche.getDescuento(), noche.getDevolucion());
			butacasView.add(butacaView);
		}
		nocheView.setButacas(butacasView);
		
		nocheView.setDescuento(noche.getDescuento().toString());
		nocheView.setFecha(noche.getFecha());
		nocheView.setFechaFinAnticipada(noche.getFechaFinAnticipada());
		nocheView.setIdNoche(noche.getIdNoche());
		nocheView.setDevolucion(noche.getDevolucion());
		nocheView.setHoraInicio(noche.getHoraInicio().toString());
		List<BandaView> bandasView = new ArrayList<BandaView>();
		for (Banda banda : noche.getListaBandas()) {
			BandaView bandaView = TransformerBandasView.transformBanda(banda);
			bandasView.add(bandaView);
		}
		nocheView.setListaBandas(bandasView);
		
		nocheView.setNumero(noche.getNumero().toString());
		
		return nocheView;
	}
}
