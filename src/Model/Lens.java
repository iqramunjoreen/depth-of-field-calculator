package Model;
/**
 * This class stores info about a single lens
 */
public class Lens {

    private String make;
    private double maxAperture; //F-number; larger aperture has smaller F-number
    private double focalLen; //higher focal length is more zoomed in

    public Lens(String make, double maxAperture, double focalLen) {
        this.make = make;
        this.maxAperture = maxAperture;
        this.focalLen = focalLen;
    }

    public double getMaxAperture() {
        return maxAperture;
    }

    public double getFocalLen() {
        return focalLen;
    }

    public void print() {
        System.out.println("  " + this.make + "        f/" + this.maxAperture + "            " + this.focalLen + "mm");
    }

}

