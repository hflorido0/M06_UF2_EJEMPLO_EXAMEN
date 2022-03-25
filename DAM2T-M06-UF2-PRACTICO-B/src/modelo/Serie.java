package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Serie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "id_serie")
	private List<Mueble> muebles;
	
	
	public Serie() {}
	
	public Serie(String nombre) {
		this.nombre = nombre;
		this.muebles = new ArrayList<>();
	}
	
	public void addMueble(Mueble mueble) {
		this.muebles.add(mueble);
	}

	@Override
	public String toString() {
		return "Serie [id=" + id + ", nombre=" + nombre + ", muebles=" + muebles
				+ "]";
	}
	
}
