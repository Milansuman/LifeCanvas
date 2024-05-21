package com.lifecanvas.lifecanvas;

import java.util.EventListener;

public interface UpdateEventListener extends EventListener {
    void onUpdate(UpdateEvent event);
}
