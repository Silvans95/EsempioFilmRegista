package it.prova.model;

public class Regista {
	
	private long id;
	private String nome;
	private String cognome;
	private int numeroOscarVinti;
	
	public Regista() {
		// TODO Auto-generated constructor stub
	}

	public Regista(String nome, String cognome, int numeroOscarVinti) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numeroOscarVinti = numeroOscarVinti;
	}

	// GET SET
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getNumeroOscarVinti() {
		return numeroOscarVinti;
	}

	public void setNumeroOscarVinti(int numeroOscarVinti) {
		this.numeroOscarVinti = numeroOscarVinti;
	}

	@Override
	public String toString() {
		return "Regista [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", numeroOscarVinti="
				+ numeroOscarVinti + "]";
	}
	
	
	
	
}
