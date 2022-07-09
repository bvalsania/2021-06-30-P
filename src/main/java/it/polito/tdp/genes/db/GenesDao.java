package it.polito.tdp.genes.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.genes.model.Coppia;
import it.polito.tdp.genes.model.Genes;


public class GenesDao {
	
	public List<Genes> getAllGenes(){
		String sql = "SELECT DISTINCT GeneID, Essential, Chromosome FROM Genes";
		List<Genes> result = new ArrayList<Genes>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Genes genes = new Genes(res.getString("GeneID"), 
						res.getString("Essential"), 
						res.getInt("Chromosome"));
				result.add(genes);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	
	
	public List<String> getvertici(){
		String sql = "SELECT DISTINCT c.Localization AS l "
				+ "FROM classification c "
				+ "ORDER BY l ";
		
		List<String> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				result.add(res.getString("l"));
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	
	
	
	public List<Coppia> getArchi(){
		String sql = "SELECT c1.Localization AS l1, c2.Localization AS l2,g.`Type` AS t, COUNT(g.`Type`) AS peso "
				+ "FROM classification c1, classification c2, interactions g "
				+ "WHERE c1.GeneID=g.GeneID1 "
				+ "		AND c2.GeneID=g.GeneID2 "
				+ "		AND c1.Localization<>c2.Localization "
				+ "GROUP BY c1.Localization,c2.Localization ";
		List<Coppia> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				result.add(new Coppia (res.getString("l1"),res.getString("l2"),res.getInt("peso") ));
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
	public List<String> getAllLocalization(){
		String sql = "SELECT DISTINCT localization "
				+ "FROM classification "
				+ "ORDER BY localization ";
		List<String> result = new ArrayList<String>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				result.add(res.getString("localization"));
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	
	public List<Coppia> getArchi(){
		String sql = "SELECT c1.Localization l1, c2.Localization l2, i.GeneID1, i.GeneID2, i.`Type`, COUNT(i.`Type`) AS peso "
				+ "FROM interactions i, classification c1, classification c2 "
				+ "WHERE c1.GeneID = i.GeneID1 AND c2.GeneID= i.GeneID2 AND c1.Localization<>c2.Localization "
				+ "GROUP BY c1.Localization , c2.Localization "
				+ "ORDER BY l1 ";
		
		List<Coppia> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				result.add(new Coppia(res.getString("l1"), res.getString("l2"), res.getInt("peso")));
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
*/
	
}
