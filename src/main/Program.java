package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    private static boolean loggedIn = false;
    private static String savedLibraryNumber = "";

    public static void main(String[] args) {
        while (true) {
            displayMenu();

            int userChoice = 0;
            try {
                String value = getUserInput("Your Selection: ");
                userChoice = Integer.parseInt(value);
            } catch (Exception e) {
                System.out.println("Enter a valid integer!!");
            }

            if (userChoice == 1) {
                displayBooks();
            } else if (userChoice == 2) {
                checkOutBooks();
            } else if (userChoice == 3) {
                if (loggedIn()) {
                    System.out.println("\nYour library number is " + savedLibraryNumber);
                } else {
                    System.out.println("\nPlease talk to Librarian. Thank you.");
                }
            } else if (userChoice == 4) {
                displayMovies();
            } else if (userChoice == 5) {
                clearLogin();
                login();
            } else if (userChoice == 9) {
                System.out.println("Quitting...");
                break;
            } else {
                System.out.println("\nEnter a valid integer!!");
            }
        }
    }

    private static void login() {
        try {
            String libraryNumber = getUserInput("Enter your library number");
            if (validLibraryNumber(libraryNumber)) {
                try {
                    if (validPassword(getUserInput("Enter your Password:"))) {
                        loggedIn = true;
                        savedLibraryNumber = libraryNumber;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void checkOutBooks() {
        int bookCount = 0;
        try {
            bookCount = Integer.parseInt(getUserInput(" Please enter the number of the book you wish to checkout: "));
        } catch (Exception e) {
            System.out.println("Enter a valid integer!!");

        }
        switch (bookCount) {
            case 1:
            case 2:
            case 3:
            case 4:
                successfulCheckOut();
                break;
            default:
                System.out.println("\nSorry we don't have that book yet.");
        }
    }

    private static void displayBooks() {
        System.out.println(" 1. Sweet Valley High vol. 4 by John Travolta ");
        System.out.println(" 2. eXtreme Programming Explained by Kent Beck ");
        System.out.println(" 3. How to Win Friends and Influence People by Dale Carnagie ");
        System.out.println(" 4. How to Cheat at TWU Assignements by Anonymous ");
    }

    private static void displayMenu() {
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
        System.out.println("**********************************************************");
        System.out.println("*                Menu                                    *");
        System.out.println("*         =====================                          *");
        System.out.println("*         1. List Book Catalog                           *");
        System.out.println("*         2. Check out Book                              *");
        System.out.println("*         3. Check Library Number                        *");
        System.out.println("*         4. Movie Listing                               *");
        System.out.println("*         5. Login                                       *");
        System.out.println("*         9. Exit                                        *");
        System.out.println("**********************************************************");
    }

    private static void displayMovies() {
        System.out.println(displayMovieDetails("Rocky", "John G. Avildsen", "10"));
        System.out.println(displayMovieDetails("Rocky II", "John G. Avildsen", "9"));
        System.out.println(displayMovieDetails("Rocky III", "John G. Avildsen", "8"));
        System.out.println(displayMovieDetails("Rocky IV", "John G. Avildsen", "7"));
        System.out.println(displayMovieDetails("Rocky V", "John G. Avildsen", "8"));
        System.out.println(displayMovieDetails("Drainage", "Francisco Trindade", "N/A"));
        System.out.println(displayMovieDetails("The Shawshank Redemption", "Frank Darabont", "10"));
        System.out.println(displayMovieDetails("The Godfather", "Francis Ford Coppola", "7"));
        System.out.println(displayMovieDetails("Inception", "Frank Darabont", "10"));
        System.out.println(displayMovieDetails("Pulp Fiction", "Quentin Tarantino", "6"));
    }

    private static void successfulCheckOut() {
        System.out.println("\nThank You! Enjoy the book.");
    }

    private static boolean validPassword(String password) {
        return "bhaisahab".equals(password);
    }

    private static boolean validLibraryNumber(String libraryNumber) {
        return libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d");
    }

    private static boolean loggedIn() {
        return loggedIn;
    }

    private static void clearLogin() {
        loggedIn = false;
        savedLibraryNumber = "";
    }

    private static String displayMovieDetails(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }

    static String getUserInput(String prompt) throws IOException {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}

