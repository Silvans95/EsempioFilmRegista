package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.Regista;

public class RegistaDao {
	// ======================================================================
	// Leggere la tabella ===============================================
	public List<Regista> list() {

		Connection c = null;
		ResultSet rs = null; // public interface ResultSet
		Statement s = null;
		Regista temp = null;
		List<Regista> result = new ArrayList<Regista>();

		try {
			c = MyConnection.getConnection();
			s = c.createStatement();

			rs = s.executeQuery("SELECT*FROM regista");

			while (rs.next()) {
				temp = new Regista();
				temp.setNome(rs.getString("NOME"));
				temp.setCognome(rs.getString("COGNOME"));
				temp.setId(rs.getLong("id"));
				temp.setNumeroOscarVinti(rs.getInt("NUMEROOSCARVINTI"));
				result.add(temp);

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				s.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	// inserire nella lista
	// =========================================================

	public int insert(Regista input) {

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO regista (nome, cognome, numeroOscarVinti) VALUES (?, ?, ?);");
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setInt(3, input.getNumeroOscarVinti());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// ======================================================================
	// aggiorna ===============================================

	public int update(Regista input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("UPDATE regista SET nome=?, cognome=?, numerooscarvinti=? where id=?;");
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setInt(3, input.getNumeroOscarVinti());
			ps.setLong(4, input.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	// ======================================================================

	// Delete dalla lista===============================================

	public int delete(Regista input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from regista where id=?;");
			ps.setLong(1, input.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Regista findByOscarVinti() {

		Connection c = null;
		ResultSet rs = null; // public interface ResultSet
		Statement s = null;
		Regista temp = null;
		List<Regista> result = new ArrayList<Regista>();
		int oscarVinti = 0;
		Regista temp2 = null;

		try {
			c = MyConnection.getConnection();
			s = c.createStatement();

			rs = s.executeQuery("SELECT*FROM regista");

			while (rs.next()) {
				temp = new Regista();
				temp.setNome(rs.getString("NOME"));
				temp.setCognome(rs.getString("COGNOME"));
				temp.setId(rs.getLong("id"));
				temp.setNumeroOscarVinti(rs.getInt("NUMEROOSCARVINTI"));
				result.add(temp);

				if (temp.getNumeroOscarVinti() > oscarVinti) {
					oscarVinti = temp.getNumeroOscarVinti();

				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				s.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return temp2;

	}

}
