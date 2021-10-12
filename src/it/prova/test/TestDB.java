package it.prova.test;

import it.prova.dao.FilmDao;
import it.prova.dao.RegistaDao;
import it.prova.model.Film;
import it.prova.model.Regista;

/**
 * @author Solving Team
 *
 */
public class TestDB {

	public static void main(String[] args) {

		System.out.println("Inizio....");
		//questi servono solo per invocare
		FilmDao filmDaoInstance = new FilmDao();
		RegistaDao registaDaoIstance = new RegistaDao();
		
		
		Film film = filmDaoInstance.selectJoinById(1L);
		
		
		film = new Film("la grande bellezza","drammatico",150);
		film.setRegista(new Regista("Paolo","Sorrentino", 10));
		filmDaoInstance.insertCompleto(film);
		
		film = new Film("justice league","cinecomics",150);
		film.setRegista(new Regista("zac","Snyder", 0));
		filmDaoInstance.insertCompleto(film);
		
		film = new Film("Armageddon","drammatico",150);
		film.setRegista(new Regista("Michael","Bay", 1));
		filmDaoInstance.insertCompleto(film);
		

		film = new Film("Once upon a time in hollywood...?","commedia",150);
		film.setRegista(new Regista("Quentin","Tarantino", 9));
		filmDaoInstance.insertCompleto(film);
		
		System.out.println("Situazione sul db....");
		for (Film filmItem : filmDaoInstance.list()) {
			System.out.println(filmItem);
		}
		System.out.println(registaDaoIstance.findByOscarVinti());
		
	}// main
}// class
