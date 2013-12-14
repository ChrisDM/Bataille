public class Main {

    public static void main(String args[]){
        JeuDeBataille jeuDeBataille;
        jeuDeBataille = new JeuDeBataille("Pascal", "Bruno");
        jeuDeBataille.distribuer();
        jeuDeBataille.jouerUnePartie();
    }
}