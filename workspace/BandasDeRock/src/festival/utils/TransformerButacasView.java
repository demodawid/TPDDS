package festival.utils;

import festival.negocio.model.Butaca;
import festival.presentacion.vistas.ButacaView;

public class TransformerButacasView {
	public static ButacaView transformButaca(Butaca butaca, Integer descuento, Integer devolucion){
		ButacaView butacaView = new ButacaView();
		
		butacaView.setIdButaca(butaca.getIdButaca());
		butacaView.setNumero(butaca.getNumero());
		butacaView.setPrecioBase(butaca.getPrecioBase());
		butacaView.setSector(butaca.getSector());
		butacaView.setDescuento(descuento);
		butacaView.setDevolucion(devolucion);
		if (butaca.getEntrada() == null) {
			butacaView.setDisponible("Si");
		} else {
			butacaView.setDisponible("No");
			butacaView.setIdEntrada(butaca.getEntrada().getIdEntrada());
		}
		return butacaView;
	}
}
