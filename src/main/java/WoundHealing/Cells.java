package WoundHealing;

import Students.Students;
import sim.field.continuous.Continuous2D;
import sim.field.network.Network;
import sim.engine.*;
import sim.util.*;

import java.util.Random;
import java.util.Scanner;

public class Cells extends SimState {

    public static Random random = new Random();
    public Continuous2D yard = new Continuous2D(1.0,100,100);
    static int numEndosStart = 50;
    static double randomMultiplier = 0.5;
    public Network endothelials = new Network(false);

    public Cells(long seed) { super(seed); }

    public void start(){
        super.start();
        yard.clear();

        for(int i = 0; i < numEndosStart; i++) {

            EndothelialCell endo = new EndothelialCell();
            int angle = i * 360 / numEndosStart;
            yard.setObjectLocation(endo,
                    new Double2D(
                            (Math.cos(angle) * yard.width / 2 * 0.8) + yard.width  / 2,
                            (Math.sin(angle) * yard.height / 2 * 0.8) + yard.height / 2));

            schedule.scheduleRepeating(endo);
        }

    }

    public static void main(String[] args) {

        doLoop(Cells.class, args);
        System.exit(0);
    }

}
