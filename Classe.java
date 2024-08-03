
import java.util.ArrayList;
import java.util.List;

//Cette class represente une salle de classe 
public class Classe {
        
	    //Attributs nom et etudiants
	
	    private String nom;
	    private List<Etudiant> etudiants;
	    
        //Contructeur pour initialiser le nom et créer une liste vide d'étudiant
	    public Classe(String nom) {
	        this.nom = nom;
	        this.etudiants = new ArrayList<>();
	    }
        
	    //getNom pour accéder à l'attribut nom et retourne le nom 
	    public String getNom() {
	        return nom;
	    }
        
	  //getNom pour accéder à l'attribut etudiant et retourne la liste d'etudiant
	    public List<Etudiant> getEtudiants() {
	        return etudiants;
	    }
	    
        //Ajoute un étudiant à la liste
	    public void ajouterEtudiant(Etudiant etudiant) {
	        etudiants.add(etudiant);
	    }
	

}
