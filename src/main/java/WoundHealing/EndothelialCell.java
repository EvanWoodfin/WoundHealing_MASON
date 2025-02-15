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

        //Move toward center for now TODO: make move towards VEGF
        sumForces.addIn(new Double2D((yard.width * 0.5 - me.x) * 0.1, (yard.height * 0.5 - me.y) * 0.1));

        //Add randomness to movement
        //sumForces.addIn(new Double2D(Cells.randomMultiplier * (Cells.random.nextDouble() * 1.0 - 0.5),
                //Cells.randomMultiplier * (Cells.random.nextDouble() * 1.0 - 0.5)));

        sumForces.addIn(me);
        cells.yard.setObjectLocation(this, new Double2D(sumForces));
    }

}
