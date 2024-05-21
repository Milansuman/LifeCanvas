package com.lifecanvas.lifecanvas;

import java.util.ArrayList;

public class UpdateEventSource {
    private final ArrayList<UpdateEventListener> listeners = new ArrayList<>();

    public void addCustomEventListener(UpdateEventListener listener) {
        listeners.add(listener);
    }

    public void removeCustomEventListener(UpdateEventListener listener) {
        listeners.remove(listener);
    }

    public void triggerUpdate() {
        UpdateEvent event = new UpdateEvent(this);
        for (UpdateEventListener listener : listeners) {
            listener.onUpdate(event);
        }
    }
}
