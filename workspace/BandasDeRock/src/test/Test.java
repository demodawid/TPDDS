package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;






import festival.negocio.model.Banda;
import festival.negocio.model.Entrada;
import festival.persistencia.dao.BandaDao;
import festival.persistencia.dao.BandaDaoImpl;
import festival.utils.HibernateUtil;


public class Test {
	public static void main(String[] args) {
/*		Session session = HibernateUtil.getSessionFactory().openSession();
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
		
		Banda unaBandaNueva = new Banda();
		unaBandaNueva.setNombre("Los Wawanco");
		
		bandaDao.save(unaBandaNueva);
		
		HibernateUtil.getSessionFactory().close();*/
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("WebContent/config.properties"));
			System.out.println(prop.getProperty("fechaHoy"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
