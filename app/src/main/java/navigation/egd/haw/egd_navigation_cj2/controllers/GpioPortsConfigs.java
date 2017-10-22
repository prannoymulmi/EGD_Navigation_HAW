package navigation.egd.haw.egd_navigation_cj2.controllers;

import android.util.Log;
import com.google.android.things.pio.Gpio;
import java.io.IOException;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.IGpioPortsConfigs;
import navigation.egd.haw.egd_navigation_cj2.constants.RaspberyPiPortsConstants;
import navigation.egd.haw.egd_navigation_cj2.listeners.IGpioPortConfigCallbackListener;
import navigation.egd.haw.egd_navigation_cj2.services.PortConfigServices.GPIOConfigServices.GpioPortConfigService;

/**
 * @author Prannoy
 * @description This class is just a demo how to use the GPIOConfig Controller to use the GPIO Ports with
 * the use of listners which inject the callback function for the GPIO port
 * Created by prann on 10/20/2017.
 */

public class GpioPortsConfigs implements IGpioPortsConfigs {
    //Declaring the GpioConfigCongtoller classes
    private GpioPortConfigService gpioSimple;
    private GpioPortConfigService gpioSimple_two;
    private GpioPortConfigService gpioSimpleInput;
    private static final String GpioTag = "GPIO Direction";

    /**
     * Initializes the GPIOPins with its Corresponding listener
     */
    public GpioPortsConfigs() {
        this.setGpioSimple();
        this.setGpioSimpleTwo();
        this.setupSimpleGpioInput();
    }

    /**
     * Configures all the GPIO ports that are declared
     */
    public void confiugureGpioPorts() {
        this.gpioSimple.ConfigurePort();
        this.gpioSimple_two.ConfigurePort();
        this.gpioSimpleInput.ConfigurePort();
    }

    /**
     * Resets the GPIO Ports
     */
    public void closeGpioPorts() {
        this.gpioSimple.ResetPort();
        this.gpioSimple_two.ResetPort();
        this.gpioSimpleInput.ResetPort();
    }

    /**
     * Setting up GPIO Ports
     */
    private void setGpioSimple(){
        this.gpioSimple = new GpioPortConfigService(RaspberyPiPortsConstants.GPIO_PIN_16, RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_HIGH);
        this.gpioSimple.setGpioPortConfigCallbackListener(new IGpioPortConfigCallbackListener() {
            @Override
            public void portCallback(Gpio gpioPort) throws IOException {
                gpioPort.setValue(!gpioPort.getValue());
                String Tag = RaspberyPiPortsConstants.GPIO_PIN_16;
                //Logging the output
                Log.d(Tag, new Boolean(gpioPort.getValue()).toString());
            }
        });

    }

    private void setGpioSimpleTwo(){
        //Initializing the config classes with their respective Port Names and settings.
        this.gpioSimple_two = new GpioPortConfigService(RaspberyPiPortsConstants.GPIO_PIN_31, RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_LOW);

        //Adding a callback methods for the GPIO port with the help of a listner
        //An Example of a listner where you have a conditional statement
        this.gpioSimple_two.setGpioPortConfigCallbackListener(new IGpioPortConfigCallbackListener() {
            private boolean isFirstRun = true;
            @Override
            public void portCallback(Gpio gpioPort) throws IOException {
                if(this.isFirstRun ==true) {
                    gpioPort.setValue(!gpioPort.getValue());
                }
                this.isFirstRun = false;
                String Tag = RaspberyPiPortsConstants.GPIO_PIN_31;
                Log.d(Tag, new Boolean(gpioPort.getValue()).toString());
            }
        });

    }

    /**
     * This methods setup an input GPIO and also shows in the comments an example how to use the interrupts with other GPIO pins
     */
    private void setupSimpleGpioInput() {
        //Initializing the config classes with their respective Port Names and settings.
        this.gpioSimpleInput = new GpioPortConfigService(RaspberyPiPortsConstants.GPIO_PIN_29, RaspberyPiPortsConstants.GPIO_DIRECTION_IN);
        this.gpioSimpleInput.setGpioPortConfigCallbackListener(new IGpioPortConfigCallbackListener() {
            @Override
            public void portCallback(Gpio gpioPort) throws IOException {

                if (gpioPort.getValue()) {
                    Log.d("Input port", new Boolean(gpioPort.getValue()).toString());
                    /**
                     * Example: you can get the port like the example below and change the values of the port
                     * GpioPortsConfigs.this.gpioSimpleInput.getPort();
                     * GpioPortsConfigs.this.gpioSimple.getPort().setValue(false);
                     */
                    // Pin is LOW
                } else {
                    // Pin is HIGH
                }
            }
        });
    }
}
