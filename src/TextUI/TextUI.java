package TextUI;

import Model.DepthOfFieldCalculator;
import Model.LensManager;
import java.util.*;

/**
 * This class interacts with the user by printing to the screen and reading from the keyboard
 */
public class TextUI {
    public static void interact(LensManager iqra) {
        while (true) {
            System.out.println(" ");
            System.out.println("=============================================");
            System.out.print("Please select a lens by inputting its number- ");
            System.out.println(" ");
            iqra.printAll();
            System.out.println("(-1 to exit)");
            Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
            int index= sc.nextInt();
            if (index == -1) {
                System.out.println("exiting...");
                break;
            }
            if (index >= iqra.numOfLenses() || index < 0) {
                System.out.println("ERROR: Invalid number.");
                continue;
            }
            System.out.print("Please input aperture- ");
            double aperture = sc.nextDouble();
            if (aperture == -1) {
                System.out.println("exiting...");
                break;
            }
            while (aperture < iqra.search(index).getMaxAperture()) {
                System.out.println("ERROR: The aperture number cannot be smaller than the lens' maximum aperture number");
                System.out.print("Please input aperture- ");
                aperture = sc.nextDouble();
            }
            System.out.print("Please input distance to the subject in metres- ");
            double distance = sc.nextDouble();
            if (distance == -1) {
                System.out.println("exiting...");
                break;
            }
            while (distance < 0) {
                System.out.println("ERROR: Distance must be positive");
                System.out.print("Please input distance to the subject in metres- ");
                distance = sc.nextDouble();
            }
            distance *= 1000;
            System.out.println(" ");

            DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(iqra.search(index), distance, aperture);
            System.out.format("Depth of Field: %.2f m\n", (calculator.depthOfField() / 1000));
            System.out.format("Hyperfocal Distance: %.2f m\n", (calculator.hyperfocal() / 1000));
            System.out.format("Near Focal Point: %.2f m\n", (calculator.nearFocal() / 1000));
            System.out.format("Far Focal Point: %.2f m\n", (calculator.farFocal() / 1000));


            System.out.println(" ");
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {

        LensManager iqra = new LensManager();
        iqra.addLens("Canon", 1.3, 85);
        iqra.addLens("Leica", 2.0, 18);
        iqra.addLens("Nikon", 5.6, 80);
        iqra.addLens("Sony", 3.5, 60);
        interact(iqra);

    }
}
