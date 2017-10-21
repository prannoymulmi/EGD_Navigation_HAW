package navigation.egd.haw.egd_navigation_cj2.services;

import com.google.android.things.pio.PeripheralManagerService;

import navigation.egd.haw.egd_navigation_cj2.Exceptions.GpioPortDirectionException;
import navigation.egd.haw.egd_navigation_cj2.listeners.IGpioPortConfigCallbackListener;
import navigation.egd.haw.egd_navigation_cj2.constants.RaspberyPiPortsConstants;

/**
 * @author Prannoy
 * @Description This a class that configures a GPIO port (Output/Input)
 * Created by prann on 10/20/2017.
 */

public class GpioPortConfigService {

    private GPIOPortOutputConfigService gpioPortOutputConfigService;
    private boolean isGPIOOutput;

    public GpioPortConfigService() {

    }

    public GpioPortConfigService(String gpioPortName, int direction) {
        this.isGPIOOutput = direction == RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_HIGH || direction == RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_LOW;
        if(this.isGPIOOutput){
            gpioPortOutputConfigService = new GPIOPortOutputConfigService(gpioPortName, direction);
        }
    }

    public GpioPortConfigService(String gpioPortName, int direction, int edge) {
        this.isGPIOOutput = direction == RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_HIGH || direction == RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_LOW;
        if(this.isGPIOOutput){
            gpioPortOutputConfigService = new GPIOPortOutputConfigService(gpioPortName, direction, edge);
        }
    }

    /**
     * Configures the GPIO Port
     */
    public void ConfigurePort() {
        if(this.isGPIOOutput){
            gpioPortOutputConfigService.ConfigurePort();
        }

    }

    /**
     *The method is reponsible to remove the callback function which is tied up to the GPIO and release it
     * for other useage
     */
    public void ResetPort() {
        if(this.isGPIOOutput){
            gpioPortOutputConfigService.ResetPort();
        }
    }


    //----------------------- Getters and Setters ----------------
    public void setGpioPortConfigCallbackListener(IGpioPortConfigCallbackListener listner) throws GpioPortDirectionException {
        if(gpioPortOutputConfigService !=null) {
            gpioPortOutputConfigService.setGpioPortConfigCallbackListener(listner);
        }
        else {
            throw new GpioPortDirectionException("The Direction of the GPIO is not in Output mode");
        }
    }

    public  PeripheralManagerService getService() {
        if(this.isGPIOOutput){
            gpioPortOutputConfigService.getService();
        }
        return null;
    }
}

