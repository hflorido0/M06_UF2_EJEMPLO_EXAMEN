package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class Mueble {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;
	@OneToOne
	@JoinColumn(name = "id_madera")
	private Madera madera;
	
	public Mueble(String nombre, Madera madera) {
		this.nombre = nombre;
		this.madera = madera;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Mueble [id=" + id + ", nombre=" + nombre + ", madera=" + madera + "]";
	}

	
}