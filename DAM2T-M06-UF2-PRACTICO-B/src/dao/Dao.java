package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import modelo.Entrada;
import modelo.Mueble;
import utils.Constants;

public class Dao {
	private Session session;
	private Connection conexion;

	public void connectar() throws SQLException {
		String url = Constants.CONNECTION;
        String user = Constants.USER_CONNECTION;
        String pass = Constants.PASS_CONNECTION;
        conexion = DriverManager.getConnection(url, user, pass);
	}

	public void desconectar() throws SQLException {
		if (conexion != null) {
            conexion.close();
        }
	}	

	public void endSession() {
		if (session != null) {
			session.close();
		}
	}

	public void initSession() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public ArrayList<Entrada> getAllEntradas() throws SQLException {
		connectar();
		ArrayList<Entrada> entradas = new ArrayList<>();;   	
		try (PreparedStatement ps = conexion.prepareStatement(Constants.GET_ALL_ENTRADA)) { 
			System.out.println(ps.toString());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					entradas.add(new Entrada(rs.getString("entrada")));
				}
			}
		}
		desconectar();
		return entradas;
		
	}
	
	public Mueble insertEntrada(String valor) throws SQLException {
		connectar();
		Mueble est = null;   	
		PreparedStatement ps = conexion.prepareStatement(Constants.INSERT_ENTRADA);
    	ps.setString(1, valor);
		System.out.println(ps.toString());
		ps.execute();
		desconectar();
		return est;
		
	}
	
	public Mueble deleteEntrada() throws SQLException {
		connectar();
    	Mueble est = null;   	
    	PreparedStatement ps = conexion.prepareStatement(Constants.DELETE_ENTRADA);
		System.out.println(ps.toString());
    	ps.execute();
    	desconectar();
    	return est;
		
	}
	
	public int insert(Object obj) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int id = (Integer) session.save(obj);
			
			tx.commit();
			System.out.println("Inserted: " + obj.toString());
			return id;
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		
		return 0;
	}
}
