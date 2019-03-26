package cs3500.animation.view.Handlers;

import cs3500.animation.view.EnhancedIView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoopHandler implements ActionListener {
    private EnhancedIView evv;
    public LoopHandler(EnhancedIView evv) {
        this.evv = evv;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        evv.toggleLoop();
    }
}
