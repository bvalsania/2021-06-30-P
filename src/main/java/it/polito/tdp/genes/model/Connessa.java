package it.polito.tdp.genes.model;

public class Connessa {

	private String g;
	private Integer peso;
	public Connessa(String g, Integer peso) {
		super();
		this.g = g;
		this.peso = peso;
	}
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return  g + "  " + peso + "\n";
	}
	
	
}
