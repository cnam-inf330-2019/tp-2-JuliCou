package net.cnam.inf330;

import java.util.Comparator;

public class PlaneFuelComparator implements Comparator<Plane> {
    @Override
    public int compare(Plane p1, Plane p2) {
        // Used for sorting in ascending order of
        // Fuel Capacity
        return p1.getFuelCapacity() - p2.getFuelCapacity();
    }
}
