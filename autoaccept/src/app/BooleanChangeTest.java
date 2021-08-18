package app;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;
import java.awt.EventQueue;

public class BooleanChangeTest implements BooleanChangeDispatcher {

    private boolean flag;
    private List<BooleanChangeListener> listeners;

    public BooleanChangeTest(boolean initialFlagState) {
        flag = initialFlagState;
        listeners = new ArrayList<BooleanChangeListener>();
    }

    @Override
    public void addBooleanChangeListener(BooleanChangeListener listener) {
        listeners.add(listener);
    }

    @Override
    public void setFlag(boolean flag) {
        if (this.flag != flag) {
            this.flag = flag;
            dispatchEvent();
        }
    }

    @Override
    public boolean getFlag() {
        return flag;
    }

    private void dispatchEvent() {
        final BooleanChangeEvent event = new BooleanChangeEvent(this);
        for (BooleanChangeListener l : listeners) {
            dispatchRunnableOnEventQueue(l, event);
        }
    }

    private void dispatchRunnableOnEventQueue(final BooleanChangeListener listener, final BooleanChangeEvent event) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                listener.stateChanged(event);
            }
        });
    }

}

interface BooleanChangeDispatcher {

    public void addBooleanChangeListener(BooleanChangeListener listener);

    public boolean getFlag();

    public void setFlag(boolean flag);

}

interface BooleanChangeListener extends EventListener {
    public void stateChanged(BooleanChangeEvent event);
}

class BooleanChangeEvent extends EventObject {
    private final BooleanChangeDispatcher dispatcher;

    public BooleanChangeEvent(BooleanChangeDispatcher dispatcher) {
        super(dispatcher);
        this.dispatcher = dispatcher;
    }
}