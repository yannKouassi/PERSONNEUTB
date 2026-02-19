import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Read {

    static void main () {
        File file = new File ( "C:\\Users\\ZBOOK\\IdeaProjects\\PERSONNEUTB\\texte.txt" );
        System.out.printf ( file.getAbsolutePath () );
        try(FileReader fileReader = new FileReader ( file );
            BufferedReader bufferedReader = new BufferedReader ( fileReader );){
            String read;
            while ( (read=bufferedReader.readLine ()) != null ){
                System.out.printf ( read );
                System.out.println ("\n" );

            }

        } catch (Exception e) {
            throw new RuntimeException ( e );
        }
    }
}
