package net.cnam.inf330;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Class for testing Airport Simulator application.
 */
public class AirportSimulatorTest {

    // TODO 2. Write a method for testing the PriorityQueue
    //...
    @Test
    public void evaluatePriorityQueue() {
        PlaneFuelComparator fuelComparator = new PlaneFuelComparator();
        Queue<Plane> flyingPlanes = new PriorityQueue<>(fuelComparator);

        NormalPlane p1 = new NormalPlane(0, "p1", true, 20);
        NormalPlane p2 = new NormalPlane(1, "p2", true, 10);
        NormalPlane p3 = new NormalPlane(2, "p3", true, 15);
        NormalPlane p4 = new NormalPlane(3, "p4", true, 30);
        NormalPlane p5 = new NormalPlane(4, "p5", true, 2);
        flyingPlanes.add(p1);
        flyingPlanes.add(p2);
        flyingPlanes.add(p3);
        flyingPlanes.add(p4);
        flyingPlanes.add(p5);

        boolean order = true;
        int value = 0;

        // Amélioration remplacer for par while
        for (Plane p : flyingPlanes) {
            if (value <= p.getFuelCapacity()){
                value = p.getFuelCapacity();
            }
            else {
                order = false;
            }
        }

        assert(order) : "Ordre de la file non respecté";

    }


    /* TODO 5. Complete this method for testing the InvalidFuelCapacityException in the
        AirportSimulator::createPlane method
     */
    @Test
    public void testInvalidFuelCapacityException() {
        AirportSimulator simulator = new AirportSimulator();
        ThrowingRunnable tr = () -> simulator.simulateTurnWithNewPlanes(3, 3, new int[]{1, 1, -1});

        // assertThrows(InvalidFuelCapacityException.class);
    }


    @Test
    public void testScenario1() {
        // Simulate scenario 1
        AirportSimulator simulator = new AirportSimulator();
        simulator.simulateTurnWithNewPlanes(3, 3, new int[]{1, 1, 1});
        simulator.simulateTurnWithNewPlanes(3, 3, new int[]{2, 2, 2});
        simulator.simulateTurnWithNewPlanes(0, 0, new int[]{0, 0, 0});
        simulator.simulateTurnWithNewPlanes(2, 3, new int[]{7, 5, 9});
        simulator.simulateTurnWithNewPlanes(2, 3, new int[]{6, 7, 5});
        simulator.simulateTurnWithNewPlanes(2, 3, new int[]{2, 9, 4});
        simulator.simulateTurnWithNewPlanes(3, 3, new int[]{1, 5, 0});
        simulator.simulateTurnWithNewPlanes(2, 3, new int[]{6, 2, 0});
        simulator.simulateTurnWithNewPlanes(1, 3, new int[]{0, 0, 0});

        // TODO 7. Test that scenario 1 does not cause any plane crashes
        // assert...
    }
}
