package net.cnam.inf330;

public interface IPlane {

    void fly();
    void takeOff(int runway);
    void land(int runway);
    void crash();

}
