package Example;

import java.util.Comparator;

public class ManOfTheYear{
    private String nomination, name, country, title, category, comment, year_of_nomination, year_of_birth, year_of_dead;
    private int nominated_age;

    public ManOfTheYear(String year_of_nomination, String nomination, String name, String country, String year_of_birth, String year_of_dead, String title, String category, String comment){
        this.year_of_nomination = year_of_nomination;
        this.nomination = nomination;
        this.name = name;
        this.country = country;
        this.year_of_birth = year_of_birth;
        this.year_of_dead = year_of_dead;
        this.title = title;
        this.category = category;
        this.comment = comment;
        try {
            Integer.parseInt(year_of_nomination);
            Integer.parseInt(year_of_birth);
            this.nominated_age = Integer.parseInt(year_of_nomination) - Integer.parseInt(year_of_birth);
        }catch (NumberFormatException e){
            this.nominated_age = 0;
        }

    }


    public String getNomination(){return nomination;}
    public void setNomination(String nomination) {this.nomination = nomination;}

    public String getName(){return name;}
    public void setName(String name) {this.name = name;}

    public String getCountry(){return country;}
    public void setCountry(String country) {this.country = country;}

    public String getTitle(){return title;}
    public void setTitle(String title) {this.title = title;}

    public String getCategory(){return category;}
    public void setCategory(String category) {this.category = category;}

    public String getComment(){return comment;}
    public void setComment(String comment) {this.comment = comment;}

    public String getYear_of_nomination(){return year_of_nomination;}
    public void setYear_of_nomination(String year_of_nomination) {this.year_of_nomination = year_of_nomination;}

    public String getYear_of_birth(){return year_of_birth;}
    public void setYear_of_birth(String year_of_birth) {this.year_of_birth = year_of_birth;}

    public String getYear_of_dead(){return  year_of_dead;}
    public void setYear_of_dead(String year_of_dead) {this.year_of_dead = year_of_dead;}

    public int getNominated_age(){return nominated_age;}
    public void setNominated_age(int nominated_age) {this.nominated_age = nominated_age;}

    @Override
    public String toString() {
        return String.format("Name - %s, Title - %s, Age of nomination - %s years", getName(), getTitle(), getNominated_age());
    }

    public static Comparator<ManOfTheYear> AgeComparator = new Comparator<ManOfTheYear>() {

        @Override
        public int compare(ManOfTheYear e1, ManOfTheYear e2) {
            return e2.getNominated_age() - e1.getNominated_age();
        }
    };
}
