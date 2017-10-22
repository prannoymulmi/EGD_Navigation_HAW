package navigation.egd.haw.egd_navigation_cj2.services.GPIOConfigServices;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManagerService;

import navigation.egd.haw.egd_navigation_cj2.listeners.IGpioPortConfigCallbackListener;
import navigation.egd.haw.egd_navigation_cj2.constants.RaspberyPiPortsConstants;

/**
 * @author Prannoy
 * @Description This a class that configures a GPIO port (Output/Input)
 * https://developer.android.com/things/sdk/pio/gpio.html
 * Created by prann on 10/20/2017.
 */

public class GpioPortConfigService {

    private GPIOPortOutputConfigService gpioPortOutputConfigService;
    private GPIOPortInputConfigService gpioPortInputConfigService;
    private boolean isGPIOOutput;

    public GpioPortConfigService() {

    }

    public GpioPortConfigService(String gpioPortName, int direction) {
        this.isGPIOOutput = direction == RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_HIGH || direction == RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_LOW;
        if(this.isGPIOOutput){
            this.gpioPortOutputConfigService = new GPIOPortOutputConfigService(gpioPortName, direction);
        } else {
            this.gpioPortInputConfigService = new GPIOPortInputConfigService(gpioPortName);
        }
    }

    public GpioPortConfigService(String gpioPortName, int direction, int edge) {
        this.isGPIOOutput = direction == RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_HIGH || direction == RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_LOW;
        if(this.isGPIOOutput){
            this.gpioPortOutputConfigService = new GPIOPortOutputConfigService(gpioPortName, direction);
        }
        else {
            this.gpioPortInputConfigService = new GPIOPortInputConfigService(gpioPortName);
        }
    }

    /**
     * Configures the GPIO Port
     */
    public void ConfigurePort() {
        if(this.isGPIOOutput){
            gpioPortOutputConfigService.ConfigurePort();
        } else {
            gpioPortInputConfigService.ConfigurePort();
        }

    }

    /**
     *The method is reponsible to remove the callback function which is tied up to the GPIO and release it
     * for other useage
     */
    public void ResetPort() {
        if(this.isGPIOOutput){
            gpioPortOutputConfigService.ResetPort();
        } else {
            gpioPortInputConfigService.ResetPort();
        }
    }


    //----------------------- Getters and Setters ----------------
    public void setGpioPortConfigCallbackListener(IGpioPortConfigCallbackListener listner) {
        if(gpioPortOutputConfigService != null) {
            gpioPortOutputConfigService.setGpioPortConfigCallbackListener(listner);
        }
        else {
            gpioPortInputConfigService.setGpioPortConfigCallbackListener(listner);
        }
    }

    public Gpio getPort() {
        if(this.isGPIOOutput){
            return gpioPortOutputConfigService.getGpioPort();
        } else {
            return gpioPortInputConfigService.getGpioPort();
        }
    }

    public  PeripheralManagerService getService() {
        if(this.isGPIOOutput){
            return gpioPortOutputConfigService.getService();
        } else {
            return gpioPortInputConfigService.getService();
        }
    }
}

