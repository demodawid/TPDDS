package test;

import java.util.List;

import org.hibernate.Session;

import festival.negocio.model.Banda;
import festival.negocio.model.Entrada;
import festival.persistencia.dao.BandaDao;
import festival.persistencia.dao.BandaDaoImpl;
import festival.utils.HibernateUtil;


public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		
		
		Entrada unaEntrada = (Entrada) session.get(Entrada.class, 2);
		
		String nombreFestival = unaEntrada.getButaca().getNoche().getFestival().getNombre();
		
		System.out.println("Se obtuvo una entrada del festival: " + nombreFestival);
		
		
		
		System.out.println("ahora intentamos obtener todas las bandas!");
		
		BandaDao bandaDao = new BandaDaoImpl();
		
		List<Banda> bandas = (List<Banda>) bandaDao.getList();
		
		int i = 0;
		for (Banda banda : bandas) {
			i++;
			System.out.println("Banda numero " + i + ": " + banda.getNombre());
		}
		HibernateUtil.getSessionFactory().close();
	}
}
