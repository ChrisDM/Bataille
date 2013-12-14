public class Carte {

    private String titre;
    private int puissance;
    private int valeurTitre;

    public Carte(int valeurTitre, int puissance) {
        this.puissance = puissance;
        this.valeurTitre = valeurTitre;
        titre = null;
        generer();
    }

    public String comparer(Carte carteAdverse){
        if (puissance > carteAdverse.puissance){
            return "gagne";
        }
        else if (puissance < carteAdverse.puissance){
            return "perdu";
        }
        else return "bataille";
    }

    public void generer(){
        switch (puissance){
            case(11): titre= "Valet";
                break;
            case(12): titre= "Dame";
                break;
            case(13): titre= "Roi";
                break;
            case(1): titre= "As"; puissance = 14;
                break;
            default: titre= Integer.toString(puissance);
        }

        switch (valeurTitre){
            case(1): titre = titre + " de coeur";
                break;
            case(2): titre = titre + " de carreau";
                break;
            case(3): titre = titre + " de trefle";
                break;
            case(4): titre = titre + " de pique";
                break;
        }
    }

    public String getTitre() {
        return titre;
    }
}

