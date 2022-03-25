package manager;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.Dao;
import modelo.Mueble;
import modelo.Serie;
import modelo.Entrada;
import modelo.Madera;

public class Manager {
	private Dao dao;
	private ArrayList<Serie> series;
	private ArrayList<Mueble> muebles;
	private ArrayList<Madera> maderas;
	
	public Manager() {
		dao = new Dao();
		this.series = new ArrayList<>();
		this.muebles = new ArrayList<>();
		this.maderas = new ArrayList<>();
	}

	public void init() {
		try {
			dao.initSession();
			iniciarJDBC();
			iniciarHibernate(dao.getAllEntradas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			dao.endSession();
			try {
				dao.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void iniciarJDBC() throws SQLException {
		dao.deleteEntrada();
		dao.insertEntrada("S VIHOLMEN");
		dao.insertEntrada("M MESAJARDIN 1 3");
	}

	private void iniciarHibernate(ArrayList<Entrada> allEntradas) {
		for (Entrada e : allEntradas) {
			String[] options = e.getEntrada().split(" ");
			System.out.println(e.getEntrada());
			Madera x;
			Serie s;
			Mueble m;
			switch (options[0]) {
				case "S":
					s = new Serie(options[1]);
					series.add(s);
					dao.insert(s);
					break;
				case "M":
					x = maderas.get(Integer.parseInt(options[2])-1);
					m = new Mueble(options[1], x);
					dao.insert(m);
					muebles.add(m);
					s = series.get(Integer.parseInt(options[3])-1);
					s.addMueble(m);
					dao.insert(s);
					break;
				case "X":
					x = new Madera(options[1], options[2]);
					dao.insert(x);
					maderas.add(x);
					break;
			}
		}
	}

}
