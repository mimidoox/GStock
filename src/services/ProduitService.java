package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Produit;

public class ProduitService implements IDao<Produit> {

	private RayonService rs;

	public ProduitService() {
		rs = new RayonService();
	}

	@Override
	public boolean create(Produit o) {
		try {
			String req=" insert into produit values(null,?,?,?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getDesignation());
			ps.setDouble(2, o.getPrixAchat());
			ps.setInt(3, o.getRayon().getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Produit o) {
		// TODO Auto-generated method stub
		try {
			String req=" delete from produit where id=?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getId());
		
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Produit newProduit) {
		try {
		String req=" update produit set designation = ? , prixAchat = ? , rayon = ? where id = ?";
		PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
		ps.setString(1, newProduit.getDesignation());
		ps.setDouble(2, newProduit.getPrixAchat());
		ps.setInt(3, newProduit.getRayon().getId());
		ps.setInt(4, newProduit.getId());
		if(ps.executeUpdate()==1) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public Produit findById(int id) {
		try {
		String req = "select * from produit where id = ?";
		PreparedStatement ps;
		ps = Connexion.getConnection().prepareStatement(req);
		ps.setInt(1, id);
		ResultSet rss = ps.executeQuery();
		while (rss.next()) {
			return new Produit(rss.getInt("id"), rss.getString("designation"), rss.getDouble("prixAchat"),rs.findById(rss.getInt("rayon")));}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			String req = "select * from produit";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rss = st.executeQuery(req);
			while (rss.next())
				produits.add(new Produit(rss.getInt("id"), rss.getString("designation"), rss.getDouble("prixAchat"),
						rs.findById(rss.getInt("rayon"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produits;
	}

}
