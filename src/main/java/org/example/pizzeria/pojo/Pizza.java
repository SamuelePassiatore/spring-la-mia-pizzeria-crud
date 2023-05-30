package org.example.pizzeria.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Il campo nome non può essere nullo")
	private String nome;
	@NotBlank(message = "Il campo descrizione non può essere nullo")
    private String descrizione;
	@NotBlank(message = "Il campo foto non può essere nullo")
    private String foto;
    @Min(value = 1, message = "Il prezzo minimo è di 1 euro")
    @Max(value = 1000, message = "Il prezzo massimo è di 1000 euro")
    private double prezzo;
    
    private boolean deleted = false;
    
    public Pizza() { }
    public Pizza(String nome, String descrizione, String foto, double prezzo) {
    	setNome(nome);
    	setDescrizione(descrizione);
    	setFoto(foto);
    	setPrezzo(prezzo);
	 }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] "
				+ "\nNome: " + getNome() 
				+ "\nDescrizione: " + getDescrizione()
				+ "\nFoto: " + getFoto()
				+ "\nPrezzo: " + getPrezzo();
	}
}
