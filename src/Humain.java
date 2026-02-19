import enumeration.Profession;
import enumeration.Sexe;

import java.util.Iterator;

public class Humain extends Table<Sexe, PersonnesGenre> {


    public Humain () {
        super();
    }

    /**
     * @param matricule de la personne
     * @param sexe de la personne
     * @return la personne avec le matricule et le sexe sexe
     * null si absent
     */
    public Personne getPersonne ( Sexe sexe , String matricule ) {

        PersonnesGenre personnesGenre = this.getValue ( sexe );
        if ( personnesGenre == null ) {
            return null;
        }
        else {
            Personne personne = personnesGenre.getValue ( matricule );
            if ( personne == null ) {
                return null;
            }
            else return personne;
        }
    }




    /**
     * @param name nom des personnes
     * @return nombre de personnes de this avec pour nom name
     */

    public int countPersonne(String name){
        int count =0;
        Iterator <Sexe> iterator1 = this.iterator ();

        while ( iterator1.hasNext () ){
            Sexe sexe = iterator1.next ();

            PersonnesGenre personnesGenre=this.getValue ( sexe );

            Iterator <String> iterator2 = personnesGenre.iterator ();

            while ( iterator2.hasNext () ){
                String matricule = iterator2.next ();

                Personne personne= personnesGenre.getValue ( matricule );

                if(personne.getNom ().equals ( name )){
                    count += 1;
                }
            }

        }
        return count;
    }




    /**
     *
     * @return le name de la personne la plus agée
     */

    public String strongestAge(){
        Iterator <Sexe> iterator1 = this.iterator ();
        int age =0;
        String name=null;

        while ( iterator1.hasNext () ){
            Sexe sexe = iterator1.next ();

            PersonnesGenre personnesGenre=this.getValue ( sexe );

            Iterator <String> iterator2 = personnesGenre.iterator ();

            while ( iterator2.hasNext () ){
                String matricule = iterator2.next ();

                Personne personne= personnesGenre.getValue ( matricule );
                if(personne.getAge ()>=age){
                    age=personne.getAge ();
                    name=personne.getNom ();

                }


            }

        }
        return name;
    }





    /**
     * Supprimer de this toutes les personnes dont la profession de type profession
     * @param profession de la personne
     */
    public void remove( Profession profession){
        Iterator <Sexe> iterator1 = this.iterator ();

        while ( iterator1.hasNext () ){
            Sexe sexe = iterator1.next ();

            PersonnesGenre personnesGenre=this.getValue ( sexe );

            Iterator <String> iterator2 = personnesGenre.iterator ();

            while ( iterator2.hasNext () ){
                String matricule = iterator2.next ();

                Personne personne= personnesGenre.getValue ( matricule );
                Profession prof = personne.getProfession ();
                if ( prof.equals ( profession ) ){
                    iterator2.remove ();

                }

            }

        }

    }





    /**
     * @param name nom de la personne
     * @param surname prenom de la personne
     *
     *    @param age age;
     *    @param matricule;
     *    @param sexe;
     *    @param profession;
     *
     */


    public void addPersonne( String name, String surname, int age, String matricule, Sexe sexe,Profession profession){
        PersonnesGenre personnesGenre=this.getValue ( sexe );
        if(personnesGenre!=null){
            Personne personneExiste = personnesGenre.getValue ( matricule );

            if(personneExiste==null){
                    Personne personne = new Personne ( name , surname , age , sexe , profession );
                    personnesGenre.addValue ( matricule , personne );
                    this.addValue ( sexe , personnesGenre );
                    System.out.println ("ajouté avec succès" );

            }
            else {
                System.out.println ("Le matricule "+ matricule + "existe déja.\n" );
                System.out.println ("ajout échoué" );

            }

        }
        else {
            Personne personne = new Personne ( name , surname , age , sexe , profession );
            PersonnesGenre personnesGenre1= new PersonnesGenre ();
            personnesGenre1.addValue ( matricule,personne );
            this.addValue ( sexe,personnesGenre1 );
            System.out.println ("ajouté avec succès" );

        }
    }



    /**
     * afficher toutes les personnes
     */
    public void affichePersonne(){
        Iterator <Sexe> iterator1 = this.iterator ();
        while ( iterator1.hasNext () ){
            Sexe sexe=iterator1.next ();
            PersonnesGenre personnesGenre = this.getValue ( sexe );
            Iterator <String> iterator2 = personnesGenre.iterator ();
            System.out.println ("_______"+sexe+"_______\n" );
            while ( iterator2.hasNext () ){
                String matricule=iterator2.next ();
                System.out.println ("Matricule : "+matricule+"\t \t" );
                Personne personne=personnesGenre.getValue ( matricule );
                System.out.println (personne.toString ()  );

            }
            System.out.println ("_________________________________________________\n" );
        }
        if(this.isEmpty ()){
            System.out.println ("\t \tla liste est vide." );
        }

    }



    /**
     * Supprimer de this toutes les personnes dont le sexe es de type sexe
     * @param sexe de la personne
     */

    public void remove(Sexe sexe){
        Iterator<Sexe> iterator1 = this.iterator ();
        while ( iterator1.hasNext () ){
            Sexe sexe1=iterator1.next ();
            PersonnesGenre personnesGenre = this.getValue ( sexe1 );
            Iterator<String> iterator2 = personnesGenre.iterator ();
            while ( iterator2.hasNext () ){
                String matricule = iterator2.next ();
                Personne personne = personnesGenre.getValue ( matricule );
                Sexe sonSexe= personne.sexe;
                if(sonSexe.equals ( sexe )){
                    iterator2.remove ();
                }
            }


        }
    }


}









