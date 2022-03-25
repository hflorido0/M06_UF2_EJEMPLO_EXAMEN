package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Madera {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;
	@Column
	private String procedencia;
	
	public Madera (String nombre, String procedencia) {
		this.nombre = nombre;
		this.procedencia = procedencia;
	}
	
	public Madera () {}

	@Override
	public String toString() {
		return "Madera [id=" + id + ", nombre=" + nombre + "]";
	}

}
