import enumeration.Profession;
import enumeration.Sexe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class TestHumain {
    Humain humain = new Humain ( );
    Scanner scanner = new Scanner ( System.in );
    String path = "C:/Users/ZBOOK/IdeaProjects/PERSONNEUTB/texte.txt";

    public TestHumain () {
    }

    public TestHumain ( Scanner scanner ) {
        this.scanner = scanner;
    }

    /**
     * ajouter une ou plusieurs personnes
     */

    public void addPersonne () {

        char choix = 'N';

        do {
            System.out.println ( "Entrez le nom de la personne " );
            String nom = this.scanner.nextLine ( );


            System.out.println ( "Entrez le prenom de la personne " );
            String prenom = this.scanner.nextLine ( );



            System.out.println ( "Entrez le matricule de la personne " );
            String matricule = this.scanner.nextLine ( ).trim ();



            try {

                System.out.println ( "Entrez l'age personne " );
                int age = this.scanner.nextInt ( );
                this.scanner.nextLine();


                System.out.println ( "Entrez le sexe:MASCULIN ou FEMININ " );
                Sexe sexe = Sexe.valueOf ( this.scanner.nextLine ( ).trim ().toUpperCase ( ) );



                System.out.println ( "Entrez la profession: ETUDIANT, PROFESSEUR , DIRECTEUR , AUTRE " );
                Profession profession = Profession.valueOf ( this.scanner.nextLine ( ).trim ( ).toUpperCase () );



                this.humain.addPersonne ( nom , prenom , age , matricule , sexe , profession );

                // je vais appeler la fonction pour le fichier
                this.enregistrer ( nom,prenom,age,matricule,sexe,profession );



            } catch (Exception e) {
                System.out.println ( "\n----erreur respectez la consigne------\n" );
                addPersonne ( );
            } finally {
                System.out.println ( "Voulez vous ajouter de nouveau? OUI ou NON" );
                String monChoix = this.scanner.nextLine ( ).trim ();
                choix = monChoix.toUpperCase ( ).charAt ( 0 );
            }
        }
        while ( choix != 'N' );


    }


    /**
     * afficher toutes les personnes
     */

    public void affiche () {
        System.out.println ( "_______________Affichage________________" );
        this.humain.affichePersonne ( );
        System.out.println ( "______________Fin Affichage______________" );

    }


    /**
     * afficher le nom de la personne la plus agé
     */

    public void strongestAge () {
        System.out.println ( "_______________Affichage________________" );
        String name = this.humain.strongestAge ( );
        if ( name == null ) {
            System.out.println ( "\t \t La liste est vide." );
        } else {
            System.out.println ( "\t \t La personne la plus agée est : " + name );
        }
        System.out.println ( "______________Fin Affichage______________" );
    }


    /**
     * Donne le nombre de personnes dont le nom est name
     */

    public void nombre () {

        System.out.println ( "Entrez un nom" );
        String name = this.scanner.nextLine ( ).trim ();

        int nombre = this.humain.countPersonne ( name );
        System.out.println ( "_______________Affichage________________" );
        if ( nombre == 0 ) {
            System.out.println ( "\t \t Il n'ya personne dont le nom est : " + name );
        } else {
            System.out.println ( "\t \tIl ya " + nombre + " personne dont le nom est : " + name );
        }
        System.out.println ( "______________Fin Affichage______________" );
    }



    /**
     * Supprimer de this toutes les personnes dont la profession de type profession
     */
    public void remove( ){
        System.out.println ("Nous avons les Professions suivantes :  ETUDIANT,\n" +
                "    PROFESSEUR,\n" +
                "    DIRECTEUR,\n" +
                "    AUTRE" );
        System.out.println ( "Entrez une profession: " );

        Profession profession1 = Profession.valueOf (  this.scanner.nextLine ( ).trim ( ));

        System.out.println ( "_______________Affichage________________" );

        this.humain.remove ( profession1 );
        System.out.println ( "\t \t Les personnes ayant pour profession "+profession1+" ont été supprimées "  );

        System.out.println ( "______________Fin Affichage______________" );
    }


    /**
     * Vérifie si une personne existe selon le sexe et le matricule
     *
     */

    public void rechercheSelonSexeMatricule(){
        System.out.println ("Entrez le sexe de la personne : " );
        Sexe sexe = Sexe.valueOf ( this.scanner.nextLine () );

        System.out.println ("Entrez le matricule de la personne : " );
        String matricule= this.scanner.nextLine () ;

        System.out.println ("Vous avez entré comme sexe : "+sexe + " et comme profession : "+ matricule );

        System.out.println ("Êtes vous sur ? si Oui tapez 1 sinon tapez 2 " );
        int choix = this.scanner.nextInt ();
        switch (choix){
            case 1:     System.out.println ("Entrez le sexe de la personne : " );
                        sexe = Sexe.valueOf ( this.scanner.nextLine () );
                        System.out.println ("Entrez le matricule de la personne : " );
                        matricule= this.scanner.nextLine () ;
                        choix=this.scanner.nextInt ();
                        break;
            case 2 :
                System.out.println ( this.humain.getPersonne ( sexe,matricule )) ;
                break;
            default: choix= this.scanner.nextInt ();
        }

    }


    /**
     * @param nom de la personne
     * @param prenom de la personne
     * @param age de la personne
     * @param matricule de la personne
     * @param sexe de la personne
     * @param profession de la personne
     *
     * Enregistre le nouvel ajout dans un fichier "C:/Users/ZBOOK/IdeaProjects/PERSONNEUTB/texte.txt"
     */

    public void enregistrer( String nom ,String prenom ,int  age ,String matricule ,Sexe sexe ,Profession profession ){
        Date date = new Date (  );

        try(FileWriter fileWriter= new FileWriter ( this.path,true );
            BufferedWriter bufferedWriter = new BufferedWriter ( fileWriter );
        ) {
            bufferedWriter.write ( "_____Enregistrement du " + date.toInstant ()+"_____");
            bufferedWriter.newLine ();

            bufferedWriter.write ("\tLe nom est : "+nom );
            bufferedWriter.newLine ();

            bufferedWriter.write ("\tLe prenom est : "+prenom );
            bufferedWriter.newLine ();

            bufferedWriter.write ("\tL'age est : "+age );
            bufferedWriter.newLine ();

            bufferedWriter.write ("\tLe matricule est : "+matricule );
            bufferedWriter.newLine ();

            bufferedWriter.write ("\tLe sexe est : "+sexe );
            bufferedWriter.newLine ();

            bufferedWriter.write ("\tLa profession est : "+profession );
            bufferedWriter.newLine ();

            bufferedWriter.write ("\n \n" );
            bufferedWriter.newLine ();


        } catch (IOException e) {
            throw new RuntimeException ( e );
        }
    }
}
