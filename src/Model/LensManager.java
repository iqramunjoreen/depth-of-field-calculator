package Model;

import java.util.ArrayList;
import java.util.List;
/**
 * This class stores a collection of lenses. It supports adding new lenses,
 * retrieving a specific lens by its index, and is iterable over all lenses
 */
public class LensManager
{
    private List<Lens> lenses = new ArrayList<Lens>();

    // add new lens
    public void addLens(String make, double maxAperture, int focalLen) {
        lenses.add(new Lens(make, maxAperture, focalLen));
    }

    // retrieve specific lens using its index
    public Lens search(int i) {
        return lenses.get(i);
    }

    // find number of lenses in collection
    public int numOfLenses() {
        return lenses.size();
    }

    // print specific lens using its index
    public void print1(int i) {
        search(i).print();
    }

    // print all lenses in collection
    public void printAll() {
        System.out.println("   ");
        System.out.println("  make    maximum aperture    focal length");
        for (int i = 0; i < numOfLenses(); i++) {
            System.out.println(i + "--------------------------------------------");
            print1(i);
        }
        System.out.println("=============================================");
    }

    // must be iterable over all lenses???====================================================

}