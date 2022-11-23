package test;

import java.util.Date;

import entities.Client;
import entities.Commande;
import entities.Fournisseur;
import entities.LigneCommande;
import entities.Produit;
import entities.Rayon;
import services.ClientService;
import services.CommandeService;
import services.FournisseurService;
import services.LigneCommandeService;
import services.ProduitService;
import services.RayonService;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientService cs = new ClientService();
	/*	cs.create(new Client("ARRAJ mohamed", "0636147570", "mohamed.arraj@emsi-edu.ma"));
		cs.create(new Client("CHARKAOUI anass", "0678731303", "anass.charkaoui@emsi-edu.ma"));
		cs.create(new Client("Rami", "0254879555", "rami@gmail.com"));
		cs.create(new Client("Safi", "0865784554", "safi@gmail.com"));*/
		//cs.delete(cs.findById(4));
		//cs.update(new Client(3, "SAMIH saad", "0677777777", "saad.samih@emsi-edu.ma"));
	//	System.out.println(cs.findById(2));
		FournisseurService fs = new FournisseurService();
	//	fs.create(new Fournisseur("Fournisseur1", "0698551885"));
	//	fs.create(new Fournisseur("Fournisseur2", "0524472514"));
		
		RayonService rs = new RayonService();
		
		/*rs.create(new Rayon("Fruits"));
		rs.create(new Rayon("Lègumes"));
		rs.create(new Rayon("Huiles"));
		rs.create(new Rayon("Alcool"));
		System.out.println(rs.findAll());
		*/
			
		ProduitService ps = new ProduitService();
		/*ps.create(new Produit("Huilor", 45,rs.findById(18)));
		ps.create(new Produit("Lesieur", 42,rs.findById(18)));
		ps.create(new Produit("Oued souss", 35,rs.findById(18)));
		ps.create(new Produit("Alhorra", 25,rs.findById(18)));
		ps.create(new Produit("Red Label", 400,rs.findById(19)));
		ps.create(new Produit("Dom Pérignon", 2600,rs.findById(19)));
		ps.create(new Produit("Smirnoff No.21", 2499,rs.findById(19)));
		ps.create(new Produit("Belvédère", 1700,rs.findById(19)));*/
		
	//	System.out.println(ps.findById(35));
		
		
		CommandeService com = new CommandeService();
		/*com.create(new Commande(1, new Date("2022/11/23"),cs.findById(1)));
		com.create(new Commande(2, new Date("2022/10/19"),cs.findById(3)));
		com.create(new Commande(44, new Date("2022/10/19"),cs.findById(2)));*/
	//	System.out.println(com.findById(1));
		
		LigneCommandeService lcs = new LigneCommandeService();
		/*lcs.create(new LigneCommande(com.findById(1),ps.findById(34), 2, 3000));
		lcs.create(new LigneCommande(com.findById(1),ps.findById(35), 2, 1990));
		lcs.create(new LigneCommande(com.findById(1),ps.findById(36), 1, 1299));
		lcs.create(new LigneCommande(com.findById(2),ps.findById(37), 4, 2000));
		lcs.create(new LigneCommande(com.findById(44),ps.findById(33), 1, 60));*/
		
		
		for (Client c : cs.findAll()) {
			System.out.println(c);
			for (Commande cmd : com.findAll()) {
				if (cmd.getClient().getId() == c.getId()) {
					System.out.println("\t" + cmd);
					for(LigneCommande lc : lcs.findAll()) 
						if(lc.getCommande().getCode() ==cmd.getCode()) {
						System.out.println("\t - "+lc);
					
						}
					System.out.println("Total : " + lcs.getTotalPrix(cmd.getCode())+"MAD");
				}
			}
		}
		
		

		
	}

 }
