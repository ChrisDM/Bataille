import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
    public ArrayList<Carte> listeDeCarte;

    public Paquet(){
        listeDeCarte = new ArrayList<Carte>();
    }

    public Carte prendreLaPremiereCarte(int quelCarte){
        return listeDeCarte.get(listeDeCarte.size() - quelCarte);
    }

    public void ajouterUneCarteALaFin(Carte carte){
        listeDeCarte.add(0, carte);
    }

    public void suprimerLaPremiereCarte(){
        listeDeCarte.remove(listeDeCarte.size()-1);
    }

    public void mettreEnDessous(){
         listeDeCarte.add(0, listeDeCarte.remove(listeDeCarte.size()-1));
    }

    private void melangerLesCartes(){
        Collections.shuffle(listeDeCarte);
    }

    public void preparer(int nbrDeCartes){
        int nbrDePuissance = (nbrDeCartes / 4);

        for (int i = 1; i <= 4; i++){
            for(int j=1; j<=nbrDePuissance; j++){
                listeDeCarte.add(new Carte(i, j));
            }
        }
        melangerLesCartes();
    }

    public Carte getCarte(){
        return listeDeCarte.get(listeDeCarte.size()-1);
    }

    public boolean estVide(){
        return (listeDeCarte.isEmpty());
    }
}
