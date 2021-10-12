package it.prova.model;

public class Film {

	private long id;
	private String titolo;
	private String genere;
	private int durata;
	private Regista regista;
	
	public Film() {
		// TODO Auto-generated constructor stub
	}

	public Film(String titolo, String genere, int durata) {
		super();
		this.titolo = titolo;
		this.genere = genere;
		this.durata = durata;
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public Regista getRegista() {
		return regista;
	}

	public void setRegista(Regista regista) {
		this.regista = regista;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titolo=" + titolo + ", genere=" + genere + ", durata=" + durata + ", regista="
				+ regista + "]";
	}
	
	
	
	
	
}
