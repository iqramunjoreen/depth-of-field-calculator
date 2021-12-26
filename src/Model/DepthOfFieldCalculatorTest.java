package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthOfFieldCalculatorTest {

    //all tests are done in mm
    @Test
    void hyperfocal() {
        LensManager manager = new LensManager();
        manager.addLens("Canon", 1.3, 85);
        manager.addLens("Leica", 2.0, 28);
        manager.addLens("Nikon", 4.6, 80);
        DepthOfFieldCalculator calculator0 = new DepthOfFieldCalculator(manager.search(0), 1000, 1.5);
        DepthOfFieldCalculator calculator1 = new DepthOfFieldCalculator(manager.search(1), 2000, 2.5);
        DepthOfFieldCalculator calculator2 = new DepthOfFieldCalculator(manager.search(2), 5000, 5);
        assertEquals(166091.95,calculator0.hyperfocal(), 0.1);
        assertEquals(10813.79,calculator1.hyperfocal(), 0.1);
        assertEquals(44137.93,calculator2.hyperfocal(),0.1);
    }

    @Test
    void nearFocal() {
        LensManager manager = new LensManager();
        manager.addLens("Canon", 1.3, 85);
        manager.addLens("Leica", 2.0, 28);
        manager.addLens("Nikon", 4.6, 80);
        DepthOfFieldCalculator calculator0 = new DepthOfFieldCalculator(manager.search(0), 1000, 1.5);
        DepthOfFieldCalculator calculator1 = new DepthOfFieldCalculator(manager.search(1), 2000, 2.5);
        DepthOfFieldCalculator calculator2 = new DepthOfFieldCalculator(manager.search(2), 5000, 5);
        assertEquals(994.52,calculator0.nearFocal(), 0.1);
        assertEquals(1691.53,calculator1.nearFocal(), 0.1);
        assertEquals(4498.55,calculator2.nearFocal(),0.1);
    }

    @Test
    void farFocal() {
        LensManager manager = new LensManager();
        manager.addLens("Canon", 1.3, 85);
        manager.addLens("Leica", 2.0, 28);
        manager.addLens("Nikon", 4.6, 80);
        DepthOfFieldCalculator calculator0 = new DepthOfFieldCalculator(manager.search(0), 1000, 1.5);
        DepthOfFieldCalculator calculator1 = new DepthOfFieldCalculator(manager.search(1), 2000, 2.5);
        DepthOfFieldCalculator calculator2 = new DepthOfFieldCalculator(manager.search(2), 5000, 5);
        assertEquals(1005.53,calculator0.farFocal(), 0.1);
        assertEquals(2446.06,calculator1.farFocal(), 0.1);
        assertEquals(5627.26,calculator2.farFocal(),0.1);
    }

    @Test
    void depthOfField() {
        LensManager manager = new LensManager();
        manager.addLens("Canon", 1.3, 85);
        manager.addLens("Leica", 2.0, 28);
        manager.addLens("Nikon", 4.6, 80);
        DepthOfFieldCalculator calculator0 = new DepthOfFieldCalculator(manager.search(0), 1000, 1.5);
        DepthOfFieldCalculator calculator1 = new DepthOfFieldCalculator(manager.search(1), 2000, 2.5);
        DepthOfFieldCalculator calculator2 = new DepthOfFieldCalculator(manager.search(2), 5000, 5);
        assertEquals(11.01,calculator0.depthOfField(), 0.1);
        assertEquals(754.53,calculator1.depthOfField(), 0.1);
        assertEquals(1128.71,calculator2.depthOfField(),0.1);
    }
}