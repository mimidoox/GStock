package test;

import java.util.Scanner;
import entities.Client;
import entities.Fournisseur;
import entities.Produit;
import entities.Rayon;
import services.ClientService;
import services.CommandeService;
import services.FournisseurService;
import services.ProduitService;
import services.RayonService;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientService cs = new ClientService();
		FournisseurService fs = new FournisseurService();
		ProduitService ps = new ProduitService();
		CommandeService com = new CommandeService();
		RayonService rs = new RayonService();
		
		while(true) {
			
			int choix=0;
			while(choix!=7) {	
				Scanner sc = new Scanner(System.in);
				System.out.println("-----------------------------------");
				System.out.println("1-Gestion clients");
				System.out.println("2-Gestion fournisseurs");
				System.out.println("3-Gestion produits");
				System.out.println("4-Gestion rayons");
				System.out.println("5-Gestion entrées");
				System.out.println("6-Gestion sorties");
				System.out.println("7-Fermer");
				System.out.println("-----------------------------------");
				System.out.print("votre choix");
				choix = sc.nextInt();
					if(choix==1) {
						
						
						System.out.println("-----------------------------------");
						System.out.println("1-Ajouter client");
						System.out.println("2-Rechercher client");
						System.out.println("3-Supprimer client");
						System.out.println("4-Afficher tous les clients");
						System.out.println("5-Retour");
						System.out.println("-----------------------------------");
						System.out.print("votre choix");
						int choix1=sc.nextInt();
						while(choix1!=6) {
							if(choix1==1) {
								System.out.print("Combien de clients vous désirez ajouter ? ");
								int nb=sc.nextInt();
								for(int i=0;i<nb;i++) {
								System.out.println("-------------Client" + (i + 1) + "---------------");	
								System.out.print("Donner le nom ");
								String n=sc.next();
								System.out.print("Donner le téléphone ");
								String t=sc.next();
								System.out.print("Donner l'email ");
								String e=sc.next();
								
								cs.create(new Client(n, t, e)); 
								System.out.println("------------------------------------------");
								}
								break;
							}
							if(choix1==2) {
								boolean res=false;
								System.out.print("Donner l'identifiant du client");
								int id=sc.nextInt();			
								for(Client c:cs.findAll()) {
									if(id==c.getId()) {
										System.out.println(c);
										res=false;
										break;
									}
									else {
										res=true;
									}}
									if(res==true) {
										System.out.println("Aucun client avec cet id !");
										break;
									}
								
									
								break;
								}
							
							if(choix1==3) {
								System.out.print("Donner l'identifiant du client que vous voudriez supprimer");
								int id=sc.nextInt();
								if(cs.delete(cs.findById(id))==true){
									System.out.println("Client est supprimé avec succès !");
									break;
								}
								else {
										System.out.println("Aucun client avec cet id !");
										choix1=2;
									}
								}
								
							if(choix1==4) {
								for(Client c:cs.findAll()) {
									System.out.println(c.toString());
								}
								break;
							}	
							if(choix1==5) {
								break;
							}
					}	
		}
					if(choix==2) {
						System.out.println("-----------------------------------");
						System.out.println("1-Ajouter fournisseur");
						System.out.println("2-Rechercher fournisseur");
						System.out.println("3-Supprimer fournisseur");
						System.out.println("4-Afficher tous les fournisseurs");
						System.out.println("5-Retour");
						System.out.println("-----------------------------------");
						System.out.print("votre choix");
						int choix1=sc.nextInt();
						while(choix1!=6) {
							if(choix1==1) {
								System.out.print("Combien de fournisseurs vous désirez ajouter ? ");
								int nb=sc.nextInt();
								for(int i=0;i<nb;i++) {
								System.out.println("-------------Fournisseur" + (i + 1) + "---------------");	
								System.out.print("Donner le nom ");
								String n=sc.next();
								System.out.print("Donner le téléphone ");
								String t=sc.next();
								fs.create(new Fournisseur(n, t)); 
								System.out.println("------------------------------------------");
								}
								break;
							}
							if(choix1==2) {
								boolean res=false;
								System.out.print("Donner l'identifiant du fournisseur");
								int id=sc.nextInt();			
								for(Fournisseur c:fs.findAll()) {
									if(id==c.getId()) {
										System.out.println(c);
										res=false;
										break;
									}
									else {
										res=true;
									}}
									if(res==true) {
										System.out.println("Aucun fournisseur avec cet id !");
										break;
									}
								
									
								break;
								}
							
							if(choix1==3) {
								System.out.print("Donner l'identifiant du fournisseur que vous voudriez supprimer");
								int id=sc.nextInt();
								if(fs.delete(fs.findById(id))==true){
									System.out.println("fournisseur est supprimé avec succès !");
									break;
								}
								else {
										System.out.println("Aucun fournisseur avec cet id !");
										choix1=2;
									}
								}
								
							if(choix1==4) {
								for(Fournisseur c:fs.findAll()) {
									System.out.println(c.toString());
								}
								break;
							}
							if(choix1==5) {
								break;
							}
					}
	}				if(choix==3) {
		System.out.println("-----------------------------------");
		System.out.println("1-Ajouter produit");
		System.out.println("2-Rechercher produit");
		System.out.println("3-Supprimer produit");
		System.out.println("4-Afficher tous les produits");
		System.out.println("5-Retour");
		System.out.println("-----------------------------------");
		System.out.print("votre choix");
		int choix1=sc.nextInt();
		while(choix1!=6) {
			if(choix1==1) {
				
				System.out.print("Combien de produits vous désirez ajouter ? ");
				int nb=sc.nextInt();
				for(int i=0;i<nb;i++) {
				System.out.println("-------------produit" + (i + 1) + "---------------");	
				System.out.print("Donner la designation ");
				String n=sc.next();
				System.out.print("Donner le prix d'achat ");
				double p=sc.nextDouble();
				System.out.print("Donner le nom du rayon ");
				String r=sc.next();
				
					try {
						ps.create(new Produit(n,p,rs.findByCode(r)));
						System.out.println("Produit bien ajouté");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
						rs.create(new Rayon(r));
						ps.create(new Produit(n,p,rs.findByCode(r)));
					}		
				 
				System.out.println("------------------------------------------");
				}
				break;
			}
			if(choix1==2) {
				boolean res=false;
				System.out.print("Donner l'identifiant du produit");
				int id=sc.nextInt();			
				for(Produit c:ps.findAll()) {
					if(id==c.getId()) {
						System.out.println(c);
						res=false;
						break;
					}
					else {
						res=true;
					}}
					if(res==true) {
						System.out.println("Aucun produit avec cet id !");
						break;
					}
				
					
				break;
				}
			
			if(choix1==3) {
				System.out.print("Donner l'identifiant du produit que vous voudriez supprimer");
				int id=sc.nextInt();
				if(ps.delete(ps.findById(id))==true){
					System.out.println("produit est supprimé avec succès !");
					break;
				}
				else {
						System.out.println("Aucun produit avec cet id !");
						choix1=2;
					}
				}
				
			if(choix1==4) {
				for(Produit c:ps.findAll()) {
					System.out.println(c.toString());
				}
				break;
			}

			if(choix1==5) {
				break;
			}
	}
		
	}
	if(choix==4) {
		System.out.println("-----------------------------------");
		System.out.println("1-Ajouter rayon");
		System.out.println("2-Rechercher rayon");
		System.out.println("3-Supprimer rayon");
		System.out.println("4-Afficher tous les rayons");
		System.out.println("5-Retour");
		System.out.println("-----------------------------------");
		System.out.print("votre choix");
		int choix1=sc.nextInt();
		while(choix1!=6) {
			if(choix1==1) {
				System.out.print("Combien de rayons vous désirez ajouter ? ");
				int nb=sc.nextInt();
				for(int i=0;i<nb;i++) {
				System.out.println("-------------Rayon" + (i + 1) + "---------------");	
				System.out.print("Donner le code du rayon ");
				String r=sc.next();
				rs.create(new Rayon(r)); 
				System.out.println("------------------------------------------");
				}
				break;
			}
			if(choix1==2) {
				boolean res=false;
				System.out.print("Donner l'identifiant du Rayon");
				int id=sc.nextInt();			
				for(Rayon c:rs.findAll()) {
					if(id==c.getId()) {
						System.out.println(c);
						res=false;
						break;
					}
					else {
						res=true;
					}}
					if(res==true) {
						System.out.println("Aucun rayon avec cet id !");
						break;
					}
				
					
				break;
				}
			
			if(choix1==3) {
				System.out.print("Donner l'identifiant du rayon que vous voudriez supprimer");
				int id=sc.nextInt();
				if(rs.delete(rs.findById(id))==true){
					System.out.println("rayon est supprimé avec succès !");
					break;
				}
				else {
						System.out.println("Aucun rayon avec cet id !");
						choix1=2;
					}
				}
				
			if(choix1==4) {
				for(Rayon c:rs.findAll()) {
					System.out.println(c.toString());
				}
				break;
			}
			if(choix1==5) {
				break;
			}
	}
		
	}
					
					}

}
}}