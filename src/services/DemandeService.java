package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Demande;

public class DemandeService implements IDao<Demande>{
	DemandeService ds;
	FournisseurService fs;
	
	
	public DemandeService() {
		
		ds = new DemandeService();
		fs = new FournisseurService();
	}

	@Override
	public boolean create(Demande o) {
		// TODO Auto-generated method stub
		try {
			String req=" insert into demande values(null,?,?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setDate(1, new java.sql.Date(o.getDate().getTime()));
			ps.setInt(2, o.getFournisseur().getId());
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
	public boolean delete(Demande o) {
		// TODO Auto-generated method stub
		try {
			String req=" delete from demande where id=?";
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
	public boolean update(Demande o) {
		// TODO Auto-generated method stub
		try {
			String req=" update commande set date = ? , fournisseur = ?  where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setDate(1, new java.sql.Date(o.getDate().getTime()));
			ps.setInt(2, o.getFournisseur().getId());
			ps.setInt(3, o.getId());
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
	public Demande findById(int id) {
		// TODO Auto-generated method stub
		try {
			String req = "select * from demande where id = ?";
			PreparedStatement ps;
			ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Demande(rs.getInt("id"), rs.getDate("date"),fs.findById(rs.getInt("fournisseur")));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Demande> findAll() {
		// TODO Auto-generated method stub
		List<Demande> demandes = new ArrayList<Demande>();
		try {
			String req = "select * from commande";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			while (rs.next())
				demandes.add(new Demande(rs.getInt("id"), rs.getDate("date"),fs.findById(rs.getInt("fournisseur"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return demandes;
	}

}
