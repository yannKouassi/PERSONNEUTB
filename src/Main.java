
void main () {
    System.out.println ("_______________________________________Plateforme______________________________________\n \n" );
    Scanner scanner = new Scanner (System.in );
    TestHumain testHumain= new TestHumain (scanner);

    int choix;

    try {
        do {
            System.out.println ("1. Ajouter une personne" );
            System.out.println ("2. affiche toutes les personnes" );
            System.out.println ("3. La personne la plus agé" );
            System.out.println ("4. supprimer selon la profession" );
            System.out.println ("5. Rechercher une Personne\n" );

            System.out.println ("Choisissez un numéro : " );
            choix=testHumain.scanner.nextInt ();
            testHumain.scanner.nextLine ();

            switch (choix){
                case 1:testHumain.addPersonne () ;
                    break;
                case 2: testHumain.affiche ();
                    break;
                case 3: testHumain.strongestAge ();
                    break;
                case 4: testHumain.remove ();
                    break;
                case 5:testHumain.nombre ();
                    break;
                case 6:testHumain.rechercheSelonSexeMatricule ();
                    break;
                default:
                    System.out.println ("numéro incorrect" );
                    System.out.println (".Choisissez un numéro correct." );
                    choix=testHumain.scanner.nextInt ();
            }

        }
        while (choix == 1 || choix == 2 || choix == 3 || choix == 4 || choix == 5 || choix==6);

    }
    catch (Exception e){
        System.out.println("\nOups! \nVous n'avez pas respecté la consigne");
    }
    finally {
        System.out.println ("__________________________________Fin Programme_______________________________________" );
    }





}
