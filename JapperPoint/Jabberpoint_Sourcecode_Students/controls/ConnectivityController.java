
package control;

import java.util.ArrayList;

public class ConnectivityController {
    private FrameApplication frameApplication;
    private ArrayList<ConnectivityController> controllers;

    public ConnectivityController(FrameApplication frameApplication) {
        this.controllers = new ArrayList<>();
        this.frameApplication = frameApplication;
    }

    public void addController(ConnectivityController controller) {
        this.controllers.add(controller);
    }

    public void run() {
        initialize();

        for (ConnectivityController controller : this.controllers) {
            controller.connectToApplication(this.frameApplication);
        }
    }

    // Implement the method from the ApplicationController interface
    public void connectToApplication(FrameApplication frameApplication) {
    }

    // Add a static initialize method
    public static void initialize() {
    }
}
