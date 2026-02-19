import enumeration.Profession;
import enumeration.Sexe;

import java.util.Objects;

public class Personne {
    public String nom;
    public String prenom;
    public int age;
    protected String matricule;
    protected Sexe sexe;
    protected Profession profession;


    public Personne ( String nom , String prenom , int age , Sexe sexe , Profession profession ) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.profession = profession;
    }

    public String getNom () {
        return nom;
    }

    public void setNom ( String nom ) {
        this.nom = nom;
    }

    public String getPrenom () {
        return prenom;
    }

    public void setPrenom ( String prenom ) {
        this.prenom = prenom;
    }

    public int getAge () {
        return age;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public Sexe getSexe () {
        return sexe;
    }

    public void setSexe ( Sexe sexe ) {
        this.sexe = sexe;
    }

    public Profession getProfession () {
        return profession;
    }

    public void setProfession ( Profession profession ) {
        this.profession = profession;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;
        Personne personne = (Personne) o;
        return age == personne.age && Objects.equals ( nom , personne.nom ) && Objects.equals ( prenom , personne.prenom ) && sexe == personne.sexe && profession == personne.profession;
    }



    @Override
    public int hashCode () {
        return Objects.hash ( matricule );
    }

    @Override
    public String toString () {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", sexe=" + sexe +
                ", profession=" + profession +
                "}\n";
    }
}
