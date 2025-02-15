package WoundHealing;

import Students.Students;
import sim.display.Console;
import sim.display.Controller;
import sim.display.Display2D;
import sim.display.GUIState;
import sim.engine.SimState;
import sim.portrayal.continuous.ContinuousPortrayal2D;
import sim.portrayal.network.NetworkPortrayal2D;
import sim.portrayal.network.SimpleEdgePortrayal2D;
import sim.portrayal.network.SpatialNetwork2D;
import sim.portrayal.simple.OvalPortrayal2D;

import javax.swing.*;
import java.awt.*;

public class CellsUI extends GUIState {

    public Display2D display;
    public JFrame displayFrame;
    ContinuousPortrayal2D yardPortrayal = new ContinuousPortrayal2D();

    public static void main(String[] args)
    {
        CellsUI vid = new CellsUI();
        Console c = new Console(vid);
        c.setVisible(true);
    }

    public CellsUI () {
        super(new Cells(System.currentTimeMillis()));
    }
    public void start()
    {
        super.start();
        setupPortrayals();
    }

    public void load(SimState state)
    {
        super.load(state);
        setupPortrayals();
    }
    public void setupPortrayals()
    {
        Cells cells = (Cells) state;
// tell the portrayals what to portray and how to portray them
        yardPortrayal.setField( cells.yard );
        yardPortrayal.setPortrayalForClass(EndothelialCell.class, new OvalPortrayal2D(Color.red));

// reschedule the displayer
        display.reset();
        display.setBackdrop(Color.white);
// redraw the display
        display.repaint();
    }
    public void init(Controller c)
    {
        super.init(c);
        display = new Display2D(600,600,this);
        display.setClipping(false);
        displayFrame = display.createFrame();
        displayFrame.setTitle("Wound Healing Display");
        c.registerFrame(displayFrame); // so the frame appears in the "Display" list
        displayFrame.setVisible(true);
        display.attach( yardPortrayal, "Yard" );
    }
    public void quit()
    {
        super.quit();
        if (displayFrame!=null) displayFrame.dispose();
        displayFrame = null;
        display = null;
    }

}
