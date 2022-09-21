/*--------------------------------------------
Program 5: MPLS Dog Management System
**Programs 5 and 6 will be similar in functionality.**
The MPLS Dog Boarding company would like for you to create an application that allows for a care attendant to be able 
to create, retrieve and update dog records from the system. MPLS Dog Boarding can only have 12 dogs in their care at a time. When you select the option to **create** a dog record.  You will 
enter the dog's id, dog's name, weight and dog's age  Once information is entered for a dog, the program will display
entered information and reprompt the care attendent to select an option to exit, display, create or update dog records.  When the **update** option
is selected the care attendant will be presented with option to enter the dog's id number and reassign information
pertaining to dog.  When the **retrieve** option is selected, the user will be able to enter the dog's id and be presented
with dog information.

**Hints**
- Consider the use of parallel arrays to store dog Data.  **Declare your arrays at the class level and not in the main method.**
- Consider commenting your code and writing the code in the main method before modularizing the program.
 
#### Listed below is a detailed explanation of the requirements needed to complete the dog management system.  

## Requirement 1 (5 Points) 
Variables are properly declared and initialized; Use of Scanner Object to read input from console. Make use of constant final variables. 
Whenever possible, make sure to declare all variables that will hold data along with declaring final variables that will not change during runtime.
Proper structure used for allowing the end-user to continously select menu option until a sentinel value is entered.

## Requirement 2 (5 Points) 
Input/Output of all necessary information for each item entry; Program properly makes use of arrays/multi-dimensional arrays to structure data;
Program only accepts dog id numbers that have been entered.

## Requirement 3 (5 Points) 
The program should consist of a minimum of 5 methods.  
    1) A welcome method that describes the program.  
    2) A method to display the selection prompt
    3) A method that allows the care attendant to enter a record.  
    4) A method that allows the care attendant to update a record and 
    5) A method that allows the care attendant to retrieve an existent record.

## Requirement 4 (5 Points) 
Style - Proper use of comments, spacing, in program; use of descriptive variable names

## Requirement 5 (5 Points) 
Program is submitted by the due date listed and pushed to assigned GitHub Repository; Repository contains a minimum of three commits.

	
    [REPLACE MY INFORMATION WITH YOURS]
    Course: COMP 170, Fall 1 2022
    System: Visual Studio Code, Windows 10
    Author: Jazz Suazo
*/

import java.util.Scanner; //Importing Scanner Class
public class DogManagement {
    /*
     * Global Declaration for parallel arrays and Scanner Object
     */
    //DECLARING PARALLEL ARRAYS OUTSIDE OF MAIN METHOD TO HOLD DOG DATA use the static keyword
    static int [] dogsId = new int [12];
    static String [] dogsName = new String [12];
    static int [] dogsWeight = new int [12];
    static int [] dogsAge = new int [12];
    static int dogs = 0;

    //DECLARING SCANNER OBJECT
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //Declarations
        int optionSelected;
        final int END = 4;

        
        //Call Welcome Method
        welcome();
        
        //Assign Return Value from Prompt to Selected Option
        optionSelected = displayPrompt();
        
        //Ensure that only 1, 2, 3, 4 can be input
        while (!(optionSelected == 1) && !(optionSelected == 2) && !(optionSelected == 3) && !(optionSelected == 4)){
            System.out.println("Invalid menu option");
            optionSelected = displayPrompt();
        }
        //Enter Loop Utilizing Sentinel Number
        while (optionSelected != END){
            if (optionSelected == 1){
                if (dogs < 12){
                    System.out.println("\nYou have selected to enter a new dog.");
                    createDogRecord();
                }
                else{
                System.out.println("We cannot accomade more than 12 dogs.");
                optionSelected = END;
                }
            }
            if (optionSelected == 2){
                displayDogRecord();
            }
            if (optionSelected == 3){
                updateDogRecord();
            }
            optionSelected = displayPrompt();
            while (!(optionSelected == 1) && !(optionSelected == 2) && !(optionSelected == 3) && !(optionSelected == 4)){
                System.out.println("Invalid menu option");
                optionSelected = displayPrompt();
            }
        }
        System.out.println("Program has ended!");
    }
        
    //Welcome method that outputs introductory text explaining program
    public static void welcome(){
        System.out.println("Welcome, this program allows for a care attendant to be able to create, retrieve and update a dog record from the system.");
    }
    //Method to display prompt and return integer values
    public static int displayPrompt(){
        //Local Variables
        int menuOption;

        System.out.println("\nSelect a menu option:");
        System.out.println("\t1) Create a dog record");
        System.out.println("\t2) Display dog record");
        System.out.println("\t3) Update dog record");
        System.out.println("\t4) Exit Program");
        
        System.out.print("Enter selection here --> ");
        //INPUT
        menuOption = Integer.parseInt(scn.nextLine());

        return menuOption;
    }
    //Method to Create a Dog Record
    public static void createDogRecord(){
        //Local Variables
        int dogID;
        String dogName;
        int dogWeight;
        int dogAge;

        //Input Values to Arrays
        System.out.print("Enter Dog ID#: ");
        dogID = Integer.parseInt(scn.nextLine());
        dogsId[dogs] = dogID;

        System.out.print("Enter Dog Name: ");
        dogName = scn.nextLine();
        dogsName[dogs] = dogName;

        System.out.print("Enter Dog Weight: ");
        dogWeight = Integer.parseInt(scn.nextLine());
        dogsWeight[dogs] = dogWeight;

        System.out.print("Enter Dog Age: ");
        dogAge = Integer.parseInt(scn.nextLine());
        dogsAge[dogs] = dogAge;

        //Output Values
        System.out.println("\nThe following information has been entered:");
        System.out.println("\tID #: " + dogsId[dogs]);
        System.out.println("\tName: " + dogsName[dogs]);
        System.out.println("\tWeight: " + dogsWeight[dogs]);
        System.out.println("\tAge: " + dogsAge[dogs]);
        dogs++;
    }
    //Method to Display Dog Record
    public static void displayDogRecord(){
        //Local Variables
        int i;
        int dogId;
        int j = 0;
        System.out.println();
        //For Loop to Generate List of Dog info
        for (i = 0; i < dogs; i++){
            System.out.println("ID #: " + dogsId[i] + " for " + dogsName[i]);
        }
        //Input Dog ID to Display Dog Record
        System.out.print("Please enter ID# from above to display record: ");
        dogId = Integer.parseInt(scn.nextLine());
        
        //Find and output Dog information, Output if no match
        for (i = 0; i < dogs; i++){
            if (dogsId[i] == dogId){
                System.out.println("\tID #: " + dogsId[i]);
                System.out.println("\tName: " + dogsName[i]);
                System.out.println("\tWeight: " + dogsWeight[i]);
                System.out.println("\tAge: " + dogsAge[i]);
            }
            else {
                j++;
            }
        }
        if (j == i){
            System.out.println("ID # does not match dog ID in system");
        }
    }
    //Method to Update Dog Record
    public static void updateDogRecord(){
        int i;
        int dogId;
        int dogID;
        int j = 0;
        String dogName;
        int dogWeight;
        int dogAge;
        
        System.out.println();
        //For Loop to Generate List of Dog info
        for (i = 0; i < dogs; i++){
            System.out.println("ID #: " + dogsId[i] + " for " + dogsName[i]);
        }
        //Input Dog ID to Display Dog Record
        System.out.print("Please enter ID# from above to update record: ");
        dogId = Integer.parseInt(scn.nextLine());
         
        //Find and output Dog information, Output if no match
         for (i = 0; i < dogs; i++){
            if (dogsId[i] == dogId){
                System.out.println("You have selected to update " + dogsName[i]); 
                
                System.out.print("Enter Dog ID#: ");
                dogID = Integer.parseInt(scn.nextLine());
                dogsId[i] = dogID;

                System.out.print("Enter Dog Name: ");
                dogName = scn.nextLine();
                dogsName[i] = dogName;

                System.out.print("Enter Dog Weight: ");
                dogWeight = Integer.parseInt(scn.nextLine());
                dogsWeight[i] = dogWeight;

                System.out.print("Enter Dog Age: ");
                dogAge = Integer.parseInt(scn.nextLine());
                dogsAge[i] = dogAge;

                System.out.println("\nThe following information has been updated");
                System.out.println("\tID #: " + dogsId[i]);
                System.out.println("\tName: " + dogsName[i]);
                System.out.println("\tWeight: " + dogsWeight[i]);
                System.out.println("\tAge: " + dogsAge[i]);
            }
            else {
                j++;
            }
        }
        if (j == i){
            System.out.println("ID # does not match dog ID in system");
        }
       
    }

  
    

}
