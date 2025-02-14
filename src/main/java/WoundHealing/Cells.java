package WoundHealing;

import sim.field.continuous.Continuous2D;
import sim.field.network.Network;
import sim.engine.*;
import sim.util.Double2D;

public class Cells extends SimState {

    public Continuous2D yard = new Continuous2D(1.0,100,100);
    static int numEndosStart = 50;
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
                            Math.cos(angle) * yard.width * 0.8,
                            Math.sin(angle) * yard.width * 0.8));

            schedule.scheduleRepeating(endo);
        }

    }

}
