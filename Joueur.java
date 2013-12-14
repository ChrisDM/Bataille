public class Joueur {

    private String nom;
    public Paquet paquet;

    public Joueur(String nom){
        this.nom = nom;
        paquet = new Paquet();
    }

    public Carte tirerUneCarte(int quelCarte){
        return paquet.prendreLaPremiereCarte(quelCarte);
    }

    public void gagnerUneCarte(Carte carte){
        paquet.ajouterUneCarteALaFin(carte);
    }

    public void mettreEnDessous(){
        paquet.mettreEnDessous();
    }

    public void perdreUneCarte(){
        paquet.suprimerLaPremiereCarte();
    }

    public boolean perdu(){
        return (paquet.estVide());
    }

    public String getNom(){
        return nom;
    }

    public int taillePaquet(){
        return paquet.listeDeCarte.size();
    }

    public Carte quelEstTaCarte(){
        return paquet.getCarte();
    }
}
