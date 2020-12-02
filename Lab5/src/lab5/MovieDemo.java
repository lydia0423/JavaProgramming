package lab5;

class Movie{
    private String Mtitle, name;
    private int Myear;
    
    Movie(String t, String n, int y){
        Mtitle = t;
        name = n;
        Myear = y;
    }
    
    public void setTitle(String title){
        Mtitle = title;
    }
    
    public void setDirector(String director){
        name = director;
    }
    
    public void setYear(int year){
        Myear = year;
    }
    
    public void display(){
        System.out.println("Movie Title: " + Mtitle + "\nDirector Name: " + name + "\nMovie Year: " + Myear);
    }

}
public class MovieDemo {
    public static void main(String[] args) {
        Movie myFavouriteMovie = new Movie("Harry Potter", "JK.Rowling", 1997);
        
        myFavouriteMovie.display();
        
    }
    
}
