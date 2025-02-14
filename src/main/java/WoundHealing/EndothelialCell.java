package WoundHealing;

import sim.engine.SimState;
import sim.engine.Steppable;
import sim.field.continuous.Continuous2D;
import sim.util.Double2D;
import sim.util.MutableDouble2D;

public class EndothelialCell implements Steppable {

    public void step(SimState state) {

        Cells cells = (Cells) state;
        Continuous2D yard = cells.yard;
        Double2D me = cells.yard.getObjectLocation(this);
        MutableDouble2D sumForces = new MutableDouble2D();


    }

}
