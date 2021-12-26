package Model;
/**
 * This class can compute the depth of field values,
 * when given a lens and some information about the camera's settings
 */
public class DepthOfFieldCalculator {
    private Lens lens = new Lens("",0,0);
    private double distance;
    private double aperture;
    private double circleOfConfusion = 0.029;
    private double focalLength;
    private double maxAperture;

    public DepthOfFieldCalculator(Lens lens, double distance, double aperture) {
        this.lens = lens;
        this.distance = distance;
        this.aperture = aperture;
        this.focalLength = lens.getFocalLen();
        this.maxAperture = lens.getMaxAperture();
    }

    // With a given lens and camera settings, the hyperfocal distance
    // is the distance from the camera beyond which all objects will seem in focus.
    public double hyperfocal() {
        return (Math.pow(focalLength, 2)) / (aperture * circleOfConfusion);
    }

    // Near focal point is distance from the camera to the nearest point which will seem in focus
    public double nearFocal() {
        return (this.hyperfocal() * distance) / (this.hyperfocal() + (distance - focalLength));
    }

    // Far focal point is distance from the camera to the farthest point which will seem in focus
    public double farFocal() {
        if (distance > this.hyperfocal())
            return Double.POSITIVE_INFINITY;
        else
            return (this.hyperfocal() * distance) / ( this.hyperfocal() - (distance - focalLength));
    }

    public double depthOfField() {
        return this.farFocal() - this.nearFocal();
    }
}
