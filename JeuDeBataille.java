public class JeuDeBataille {

    private Joueur joueur1;
    private Joueur joueur2;
    private final int NBR_DE_CARTE;
    private Paquet paquet;
    private int nbrDeTour;
    private int cartesEnJeu;
    private int quelCarte;

    public JeuDeBataille(String nom1, String nom2){
        joueur1 = new Joueur(nom1);
        joueur2 = new Joueur(nom2);
        NBR_DE_CARTE = 52;
        paquet = new Paquet();
        cartesEnJeu = 0;
        quelCarte = 1;
    }

    public void distribuer(){
        paquet.preparer(NBR_DE_CARTE);

        while (!paquet.estVide()){
            joueur1.gagnerUneCarte(paquet.prendreLaPremiereCarte(quelCarte));
            paquet.suprimerLaPremiereCarte();
            joueur2.gagnerUneCarte(paquet.prendreLaPremiereCarte(quelCarte));
            paquet.suprimerLaPremiereCarte();
        }
    }

    public void jouerUnePartie(){
        while(!joueur1.perdu() && !joueur2.perdu()){
            System.out.println("test");
            jouerUnTour();
        }
        if(joueur1.perdu()){
            System.out.println("\n" + joueur2.getNom() + " a gagne");
        }
        else{
            System.out.println("\n" + joueur1.getNom() + " a gagne");
        }
    }

    private void jouerUnTour(){
        Carte carteJoueur1 = joueur1.tirerUneCarte(quelCarte);
        Carte carteJoueur2 = joueur2.tirerUneCarte(quelCarte);
        cartesEnJeu++;
        nbrDeTour++;

        System.out.println("Tour N°" + nbrDeTour + " - " + joueur1.getNom() + " tire " + carteJoueur1.getTitre() + " contre " +
                joueur2.getNom() + " qui tire " + carteJoueur2.getTitre());

        switch (carteJoueur1.comparer(carteJoueur2)){
            case "bataille":
                System.out.println("--------------------------- Bataille! ---------------------------");
                if ((joueur1.taillePaquet() - cartesEnJeu > 1) && (joueur2.taillePaquet() - cartesEnJeu > 1)){
                    cartesEnJeu++;
                    quelCarte += 2;
                }
                /* Les 2 conditions si un joueur n'a plus assez de cartes pour la bataille */
                else if (joueur1.taillePaquet() - cartesEnJeu == 1){
                    gagnerLePot(joueur2, joueur1);
                }
                else if (joueur2.taillePaquet() - cartesEnJeu == 1){
                    gagnerLePot(joueur1, joueur2);
                }
                break;

            case "gagne": gagnerLePot(joueur1, joueur2);
                break;

            case "perdu": gagnerLePot(joueur2, joueur1);
                break;
        }

        System.out.println(joueur1.getNom() + ": " + (joueur1.taillePaquet() - cartesEnJeu));
        System.out.println(joueur2.getNom() + ": " + (joueur2.taillePaquet() - cartesEnJeu) + "\n");
    }

    private void gagnerLePot(Joueur jGagnant, Joueur jPerdant){
        while ((cartesEnJeu != 0) && !(jPerdant.perdu())){
            jGagnant.gagnerUneCarte(jPerdant.quelEstTaCarte());
            jPerdant.perdreUneCarte();
            jGagnant.mettreEnDessous();
            quelCarte = 1;
            cartesEnJeu--;
        }
        cartesEnJeu = 0;
    }
}
