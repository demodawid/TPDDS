package festival.utils;

import java.util.ArrayList;
import java.util.List;

import festival.negocio.model.Festival;
import festival.negocio.model.Noche;
import festival.persistencia.vistas.FestivalView;
import festival.persistencia.vistas.NocheView;

public class TransformerFestivalesView {
	public static FestivalView transformFestival(Festival festival){
		FestivalView festivalView =  new FestivalView();
		
		festivalView.setIdFestival(festival.getIdFestival());
		
		List<NocheView> nochesView = new ArrayList<NocheView>();
		for (Noche noche : festival.getNoches()) {
			NocheView nocheView = TransformerNochesView.transformNoche(noche);
			nochesView.add(nocheView);
		}
		festivalView.setNoches(nochesView);
		festivalView.setNombre(festival.getNombre());
		festivalView.setPredio(festival.getPredio());
		
		return festivalView;
	}
}
