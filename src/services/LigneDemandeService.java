package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.LigneDemande;

public class LigneDemandeService implements IDao<LigneDemande> {
	DemandeService ds;
	ProduitService ps;
	
	
	public LigneDemandeService() {
		this.ds = new DemandeService();
		this.ps = new ProduitService();
	}

	@Override
	public boolean create(LigneDemande o) {
		// TODO Auto-generated method stub
		try {
			String req=" insert into lignedemande values(null,?,?,?,?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getDemande().getId());
			ps.setInt(2, o.getProduit().getId());
			ps.setInt(3, o.getQuantite());
			ps.setDouble(4, o.getPrixVente());
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
	public boolean delete(LigneDemande o) {
		// TODO Auto-generated method stub
		try {
			String req=" delete from lignedemande where demande=? and produit=?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getDemande().getId());
			ps.setInt(2, o.getProduit().getId());
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
	public boolean update(LigneDemande o) {
		// TODO Auto-generated method stub
		try {
			String req=" update lignedemande set quantité = ? , prixVente = ?  where demande = ? and produit= ? and id = ? ";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getQuantite());
			ps.setDouble(2, o.getPrixVente());
			ps.setInt(3, o.getDemande().getId());
			ps.setInt(4, o.getProduit().getId());
			ps.setInt(5, o.getId());
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
	public LigneDemande findById(int id) {
		// TODO Auto-generated method stub
		try {
			String req = "select * from lignedemande where id = ?";
			PreparedStatement pss = Connexion.getConnection().prepareStatement(req);
			pss.setInt(1, id);
			ResultSet rs = pss.executeQuery();
			while (rs.next()) {
				return new LigneDemande(rs.getInt("id"),ds.findById(rs.getInt("demande")),ps.findById(rs.getInt("produit")),rs.getInt("quantité"),rs.getDouble("prixVente"));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<LigneDemande> findAll() {
		// TODO Auto-generated method stub
		List<LigneDemande> lignedemandes = new ArrayList<LigneDemande>();
		try {
			String req = "select * from lignecommande";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			while (rs.next())
				lignedemandes.add(new LigneDemande(ds.findById(rs.getInt("demande")),ps.findById(rs.getInt("produit")),rs.getInt("quantité"),rs.getDouble("prixVente")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lignedemandes;
	}
	
	public double getTotalPrix(int code) {
		double total = 0;
		String req = "select SUM(prixVente*quantité) from lignedemande where demande= ?";
		try {
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, code);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				total=rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
		
	}
	

}
