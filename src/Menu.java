import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public abstract class Menu {

    private final Scanner scanner;
    private final ArrayList<Media>  sampleLibrary;

    public Menu(Scanner scanner, ArrayList<Media> sampleLibrary){
        this.scanner = scanner;
        this.sampleLibrary = sampleLibrary;
    }

    protected Scanner getScanner(){
        return scanner;
    }

    protected ArrayList<Media> getSampleLibrary(){
        return sampleLibrary;
    }

    protected String promptUser(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    protected abstract void setMenu();

    protected abstract boolean handleChoice(int choice);

    public final void setUp(){
        //the bulk of conditional logic sits  here

            boolean isRunning = true; //once the program is running, set a boolean flag to true initially

            //always run the program while the boolean is true
            while (isRunning) {
                //call the above method to set up the menu
                setMenu();
                //try some risky code within the try-catch block.
                try {
                    int choice = scanner.nextInt(); //scanner will expect an Int
                    scanner.nextLine();

                     isRunning = handleChoice(choice);

                } catch (InputMismatchException ex) { //If something other than an Int is input, we catch the exception
                    System.out.println("Error! Invalid input! Ensure Input is a valid choice and try again!\n");
                    scanner.nextLine();
                }
            }

        }


    }
