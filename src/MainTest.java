import java.io.File;


    void main () {
        File f = new File ("test.txt" );
        System.out.println ("Chemin absolu du fichier : " + f.getAbsolutePath () );
        System.out.println ("Nom du fichier : " + f.getName () );
        System.out.println ("Est ce que le fichier exite " + f.exists () );
        System.out.println ("Est-ce un répertoire ? " + f.isDirectory () );
        System.out.println ("Est ce un fichier ? " +f.isFile () );

        System.out.println ("Affichage des lecteurs à la racine : " );
        for ( File file : File.listRoots () ){
            System.out.println (file.getAbsoluteFile () );

            try {
                int i = 1;
                //On parcourt la liste des fichiers et répertoires
                for ( File nom : file.listFiles () ){
                    //S'il s'agit d'un dossier on ajoute un "/"
                    System.out.println ("\t \t" + ( ((nom.isDirectory ()))?nom.getName ()+"/":nom.getName () ) );
                    if((i%4) == 0){
                        System.out.println ("\n" );
                    }
                    i++;
                }
                System.out.println ("\n" );
            } catch (NullPointerException e) {
                //L'instruction peut générer une NullPointerException
                //s'il n'y a pas de sous-fichier !

            }
        }

    }


