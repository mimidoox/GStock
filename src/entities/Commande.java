package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {

	private int code;
	private Date date;
	private Client client;
	private List<LigneCommande> ligneCommandes;

	public Commande(int code, Date date, Client client) {
		super();
		this.code = code;
		this.date = date;
		this.client = client;
		this.ligneCommandes = new ArrayList<LigneCommande>();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}



	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		return "Commande : " + code + " / " + sdf.format(date);
	}

}
