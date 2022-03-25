package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Entrada {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String entrada;
	
	public Entrada (String entrada) {
		this.entrada = entrada;
	}
	
	public Entrada () {}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", entrada=" + entrada + "]";
	}

	public String getEntrada() {
		return this.entrada;
	}

}
