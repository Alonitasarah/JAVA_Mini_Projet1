import java.util.HashMap;
import java.util.Map;

//Cette classe représente les étudiants
public class Etudiant {
	
        //Attributs nom, id, notes
	    private String nom;
	    private String id;
	   
	    private Map<Matiere, Note> notes;
	    
	    
        //Contructeur pour initialiser nom, l'id et créer un dictionnaire de note vide
	    public Etudiant(String nom, String id) {
	        this.nom = nom;
	        this.id = id;
	        this.notes = new HashMap<>();
	    }
        
	    //get permet d'avoir accès à l'attribut nom et retourne le nom
	    public String getNom() {
	        return nom;
	    }

	    //get permet d'avoir accès à l'attribut id et retourne le id
	    public String getId() {
	        return id;
	    }
        
	  //get permet d'avoir accès à l'attribut note et retourne le note
	    public Map<Matiere, Note> getNotes() {
	        return notes;
	    }
        
	    //cette methode permet d'ajouter des notes pour une matiere
	    public void ajouterNote(Matiere matiere, Note note) {
	        notes.put(matiere, note);
	    }
        
	    //cette methode permet de calculer les moyennes
	    public double calculerMoyenne() {
	        double total = 0;
	        for (Note note : notes.values()) {
	            total += note.getValeur();
	        }
	        return total / notes.size();
	    }


}
