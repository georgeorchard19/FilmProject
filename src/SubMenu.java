import java.util.Scanner;
import java.util.ArrayList;

public abstract class SubMenu {

    private final Scanner scanner;
    private final ArrayList<Media>  sampleLibrary;

    public SubMenu(Scanner scanner, ArrayList<Media> sampleLibrary){
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

    public abstract void setMenu();

    public abstract void setUp();
}
