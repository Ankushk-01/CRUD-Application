
package crud_mysql.main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the CRUD Application ");
        System.out.println("This is a Book Management Console based System ");
        char ch = 'y';
        do{
        System.out.println("Choose Action you want to do : ");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Edit Book Details");
        System.out.println("4. Book Status ");
        System.out.println("5. Exit ");
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1: {
                System.out.print("Enter the Title of the Book : ");
                String title = sc2.nextLine();
                System.out.print("Enter the Author of the book : ");
                String author = sc2.nextLine();
                System.out.print("Enter the Genre of the book : ");
                String genre = sc2.nextLine();
                System.out.print("Choose availability option : 1. Available soon 2. Available now ");
                int available = sc.nextInt();

                System.out.println("Data : " + title + " " + author + " " + genre + " " + available);
                break;
            }

            case 2: {
                System.out.println("Enter the Book Name : ");
                String tittle = sc2.nextLine();
                System.out.println("The name of the book is : " + tittle);
                break;
            }
            case 3: {
                System.out.println("Enter the Book Name : ");
                String title = sc2.nextLine();
                System.out.println("The book you want to edit is : " + title);
                System.out
                        .println(
                                "Which field you want to edit :\n 1. Title \n 2. Author \n 3. Genre \n 4. Status \n ");
                int choose = sc.nextInt();
                switch (choose) {
                    case 1: {
                        System.out.println("Updating the Title of the book : ");
                        String name = sc2.nextLine();
                        System.out.println("UPdated name of the book is : " + name);
                    }
                    case 2: {
                        System.out.println("Updating the Author of the book : ");
                        String author = sc2.nextLine();
                        System.out.println("UPdated name of the book is : " + author);
                    }
                    case 3: {
                        System.out.println("Updating the Genre of the book : ");
                        String genre = sc2.nextLine();
                        System.out.println("UPdated name of the book is : " + genre);
                    }
                    case 4: {
                        System.out.println("Updating the Status of the book : ");
                        String status = sc2.nextLine();
                        System.out.println("UPdated name of the book is : " + status);
                    }
                    default: {
                        System.out.println("Updating all the fields");
                        System.out.print("Enter the Title of the Book : ");
                        String name = sc2.nextLine();
                        System.out.print("Enter the Author of the book : ");
                        String author = sc2.nextLine();
                        System.out.print("Enter the Genre of the book : ");
                        String genre = sc2.nextLine();
                        System.out.print("Choose availability option : 1. Available soon 2. Available now ");
                        int available = sc.nextInt();

                        System.out.println("Data : " + name + " " + author + " " + genre + " " + available);
                    }
                }
                break;
            }
            case 4: {
                System.out.print("Enter the book Title : ");
                String title = sc2.nextLine();
                String status = "Available";
                System.out.println("The status of the book " + title + " is : " + status);
                break;
            }
            case 5 :{
                System.out.println("Thanks for using our application ");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Invalid Input Please try again !");
                System.exit(0);
                break;
            }
        }
        System.out.println("Do you want to run the application again (y or n)");
        ch = sc.next().charAt(0);
    }while(ch!='n');

    }
}
