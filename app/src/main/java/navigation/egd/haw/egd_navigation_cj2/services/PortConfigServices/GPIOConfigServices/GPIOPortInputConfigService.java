package navigation.egd.haw.egd_navigation_cj2.services.PortConfigServices.GPIOConfigServices;

import android.util.Log;
import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.GpioCallback;
import java.io.IOException;

import navigation.egd.haw.egd_navigation_cj2.constants.RaspberyPiPortsConstants;
import navigation.egd.haw.egd_navigation_cj2.listeners.IGpioPortConfigCallbackListener;
import navigation.egd.haw.egd_navigation_cj2.services.PortConfigServices.PortAvailableCheckService;

/**
 * @author Prannoy
 * Created by prann on 10/21/2017.
 * https://developer.android.com/things/sdk/pio/gpio.htmls
 */

public class GPIOPortInputConfigService extends PortAvailableCheckService {

    private Gpio gpioPort;
    private IGpioPortConfigCallbackListener listner;
    private String portName;

    public GPIOPortInputConfigService(String portName) {
        super();
        this.portName = portName;
        this.listner = null;
    }

    /**
     * Configures the GPIO Port for input
     */
    public void ConfigurePort() {
        final String TAG = "Configure Port Input";

        try{
            gpioPort = super.service.openGpio(portName);
            // Initialize the pin as an input
            gpioPort.setDirection(RaspberyPiPortsConstants.GPIO_DIRECTION_IN);
            // Low voltage is considered active
            gpioPort.setActiveType(RaspberyPiPortsConstants.GPIO_EDGE_ACTIVE_LOW);

            // Register for all state changes
            gpioPort.setEdgeTriggerType(RaspberyPiPortsConstants.GPIO_EDGE_FALLING);
            gpioPort.registerGpioCallback(mGpioCallback);

        } catch (IOException e) {
            Log.e(TAG, "Error on PeripheralIO API", e);
        }
    }

    public void ResetPort() {
        gpioPort.unregisterGpioCallback(mGpioCallback);
        if (gpioPort != null) {
            try {
                gpioPort.close();
                gpioPort = null;
            } catch (IOException e) {
                Log.w("GPIO Inupt", "Unable to close GPIO", e);
            }
        }
    }

    //GPIO Interrupt handler listner
    private GpioCallback mGpioCallback = new GpioCallback() {
        @Override
        public boolean onGpioEdge(Gpio gpio) {
            // Read the active low pin state
            try {
                listner.portCallback(gpioPort);

            } catch (IOException e) {
                e.printStackTrace();
            }

            // Continue listening for more interrupts
            return true;
        }

        @Override
        public void onGpioError(Gpio gpio, int error) {
            Log.w("Interrupt ", gpio + ": Error event " + error);
        }
    };

    public Gpio getGpioPort() {
        return gpioPort;
    }

    //----------------------- Getters and Setters ----------------
    public void setGpioPortConfigCallbackListener(IGpioPortConfigCallbackListener listner) {
        this.listner = listner;
    }

}
