/*2.Define a class named Movie. Include private data members for the title, year, 
and name of the director. Create constructors to assign initial values to data 
members. Include three public methods with prototypes void setTitle(string title); 
void setYear(int year); and void setDirector(string director);. Include another 
function that displays information about a movie. Write a main( ) function that 
creates a movie object named myFavouriteMovie. Set and display the object’s data members.
 */

package testrevision;

class Movie{
    private String title, directorName;
    private int year;
    
    Movie(String t, String dn, int y){
        title = t;
        directorName = dn;
        year = y;  
    }
    
    public void setTitle(String tlt){
        title = tlt;
    }
    
    public void setYear(int yr){
        year = yr;
    }
    
    public void setDirector(String director){
        directorName = director;
    }
    
    public void display(){
        System.out.println("Title: " + title + "\nYear: " + year + "\nDirector: " + directorName);
    }
}

public class Q2Class {
    public static void main(String[] args) {
        Movie myFavouriteMovie = new Movie("Harry Potter", "JK.Rowling", 1999);
        
        myFavouriteMovie.display();
        
        
    }
    
}
