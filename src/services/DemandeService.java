package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Demande;

public class DemandeService implements IDao<Demande>{
	FournisseurService fs;
	
	
	public DemandeService() {
		
		fs= new FournisseurService();
	}

	@Override
	public boolean create(Demande o) {
		// TODO Auto-generated method stub
		try {
			String req=" insert into demande values(?,?,?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getId());
			ps.setDate(2, new java.sql.Date(o.getDate().getTime()));
			ps.setInt(3, o.getFournisseur().getId());
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
		return demandes.remove(o);
	}

	@Override
	public boolean update(Demande o) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Demande findById(int id) {
		// TODO Auto-generated method stub
		for (Demande s : demandes) {
			if (s.getId() == id)
				return s;
		}
			
		return null;
	}

	@Override
	public List<Demande> findAll() {
		// TODO Auto-generated method stub
		return demandes;
	}

}
