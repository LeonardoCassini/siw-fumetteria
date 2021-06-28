package it.uniroma3.siw.spring.model;

import javax.persistence.*;
import java.time.*;
import java.util.List;

@Entity
public class Volume 
{
	
	private int pagine;
	@Id
	private String isbn;
	private String titolo;
	private int numVolume;
	private String sinossi;
	private float prezzo;
	private String nomeCopertina;
	private String copertina;
	private int copie;
	private LocalDate pubblicazione;
	private boolean ristampa;
	@ManyToOne
	private Opera opera;
	@ManyToMany
	private List <Ordine> ordini;
	@ManyToMany
	private List<Carrello> carrello;
	
	public int getPagine() 
	{
		return pagine;
	}
	public void setPagine(int pagine) 
	{
		this.pagine = pagine;
	}
	public String getIsbn() 
	{
		return isbn;
	}
	public void setIsbn(String isbn) 
	{
		this.isbn = isbn;
	}
	public int getNumVolume() 
	{
		return numVolume;
	}
	public void setNumVolume(int numVolume) 
	{
		this.numVolume = numVolume;
	}
	public String getSinossi() 
	{
		return sinossi;
	}
	public void setSinossi(String sinossi) 
	{
		this.sinossi = sinossi;
	}
	public float getPrezzo() 
	{
		return prezzo;
	}
	public void setPrezzo(float prezzo) 
	{
		this.prezzo = prezzo;
	}
	public String getCopertina() 
	{
		return copertina;
	}
	public void setCopertina(String copertina) 
	{
		this.copertina = copertina;
	}
	public int getCopie() 
	{
		return copie;
	}
	public void setCopie(int copie) 
	{
		this.copie = copie;
	}
	public LocalDate getPubblicazione() 
	{
		return pubblicazione;
	}
	public void setPubblicazione(LocalDate pubblicazione) 
	{
		this.pubblicazione = pubblicazione;
	}
	public boolean isRistampa() 
	{
		return ristampa;
	}
	public void setRistampa(boolean ristampa) 
	{
		this.ristampa = ristampa;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Opera getOpera() {
		return opera;
	}
	public void setOpera(Opera opera) {
		this.opera = opera;
	}
	public List<Ordine> getOrdini() {
		return ordini;
	}
	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
	public String getNomeCopertina() {
		return nomeCopertina;
	}
	public void setNomeCopertina(String nomeCopertina) {
		this.nomeCopertina = nomeCopertina;
	}
	public List<Carrello> getCarrello() {
		return carrello;
	}
	public void setCarrello(List<Carrello> carrello) {
		this.carrello = carrello;
	}
}
