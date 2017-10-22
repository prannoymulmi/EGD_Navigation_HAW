package navigation.egd.haw.egd_navigation_cj2.services.PortConfigServices.GPIOConfigServices;

import android.os.Handler;
import android.util.Log;

import com.google.android.things.pio.Gpio;

import java.io.IOException;

import navigation.egd.haw.egd_navigation_cj2.constants.RaspberyPiPortsConstants;
import navigation.egd.haw.egd_navigation_cj2.listeners.IGpioPortConfigCallbackListener;
import navigation.egd.haw.egd_navigation_cj2.services.PortConfigServices.PortAvailableCheckService;

/**
 * @author Prannoy
 * @description This class Configures the GPIO
 * https://developer.android.com/things/sdk/pio/gpio.html
 * Created by prann on 10/21/2017.
 */

public class GPIOPortOutputConfigService extends PortAvailableCheckService {
    /**
     * Injecting Listner Interface to get custom callback methods
     */
    private IGpioPortConfigCallbackListener listner;

    /**
     * GPIO Port detail Attributes
     */
    private String gpioPortName;
    private int direction;

    private Handler mHandler;
    private Gpio gpioPort;
    private static final int CALLBACK_INTERVAL = 1000;

    /**
     * Default  constructor which Hasa defualt GPIO output direction as low output intially
     * @param gpioPortName
     */
    public GPIOPortOutputConfigService(String gpioPortName){
        super();
        this.gpioPortName = gpioPortName;
        this.direction = RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_LOW;

        this.listner = null;
        mHandler = new Handler();
    }

    public  GPIOPortOutputConfigService(String gpioPortName, int direction){
        super();
        this.gpioPortName = gpioPortName;
        this.direction = direction;

        this.listner = null;
        mHandler = new Handler();
    }


    /**
     * Configures the GPIO Port for output
     */
    public void ConfigurePort() {

        final String TAG = "Configure Port Output";
        try {
            gpioPort = super.service.openGpio(this.gpioPortName);
            // Step 2. Configure as an output.
            gpioPort.setDirection(this.direction);

            mHandler.post(mCallBackRunnable);
        }  catch (IOException e) {
            Log.e(TAG, "Error on PeripheralIO API", e);
        }
    }

    /**
     *The method is responsible to remove the callback function which is tied up to the GPIO and release it
     * for other usage
     */
    public void ResetPort() {

        // Step 4. Remove handler events on close.
        mHandler.removeCallbacks(mCallBackRunnable);

        // It is important to setthe listners to null after its use to not use unwanted resources
        this.listner = null;
        // gpioPort Close the resource.
        if (gpioPort != null) {
            try {
                //Close the ports
                gpioPort.close();
            } catch (IOException e) {
                Log.e("Reset port", "Error on PeripheralIO API", e);
            }
        }
    }

    /**
     *  The Callback method which runs for the GPIO
     */
    private Runnable mCallBackRunnable = new Runnable() {
        @Override
        public void run() {
            // Exit if the GPIO is already closed
            if (gpioPort == null) {
                return;
            }
            try {
                listner.portCallback(gpioPort);
                Log.d("Inside runnable", "this is the value inside runnable");

                //Schedule another event after delay.
                mHandler.postDelayed(mCallBackRunnable, CALLBACK_INTERVAL);
            } catch (IOException e) {
                Log.d("Inside runnable Error", "this is the value inside runnable");
            }
        }
    };

    //----------------------- Getters and Setters ----------------
    public void setGpioPortConfigCallbackListener(IGpioPortConfigCallbackListener listner) {
        this.listner = listner;
    }

    public Gpio getGpioPort() {
        return gpioPort;
    }


}
