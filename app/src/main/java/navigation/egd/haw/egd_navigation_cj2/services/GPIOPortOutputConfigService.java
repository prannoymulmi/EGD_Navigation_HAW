package navigation.egd.haw.egd_navigation_cj2.services;

import android.os.Handler;
import android.util.Log;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManagerService;

import java.io.IOException;

import navigation.egd.haw.egd_navigation_cj2.constants.RaspberyPiPortsConstants;
import navigation.egd.haw.egd_navigation_cj2.listeners.IGpioPortConfigCallbackListener;

/**
 * @author Prannoy
 * @Description This class Configures the GPIO
 * Created by prann on 10/21/2017.
 */

public class GPIOPortOutputConfigService {
    /**
     * Injecting Listner Interface to get custom callback methods
     */
    private IGpioPortConfigCallbackListener listner;

    private static PeripheralManagerService service;
    /**
     * GPIO Port detail Attributes
     */
    private String gpioPortName;
    private int edge;
    private int direction;

    private Handler mHandler;
    private Gpio gpioPort;
    private static final int CALLBACK_INTERVAL = 1000;

    public GPIOPortOutputConfigService(){
        this.listner = null;
        mHandler = new Handler();
    }

    public GPIOPortOutputConfigService(String gpioPortName){
        service = new PeripheralManagerService();
        this.gpioPortName = gpioPortName;
        this.direction = RaspberyPiPortsConstants.GPIO_DIRECTION_OUT_INITIALLY_LOW;
        this.edge = RaspberyPiPortsConstants.GPIO_EDGE_FALLING;

        this.listner = null;
        mHandler = new Handler();
    }

    public  GPIOPortOutputConfigService(String gpioPortName, int direction){
        service = new PeripheralManagerService();
        this.gpioPortName = gpioPortName;
        this.edge = RaspberyPiPortsConstants.GPIO_EDGE_FALLING;
        this.direction = direction;

        this.listner = null;
        mHandler = new Handler();
    }

    public  GPIOPortOutputConfigService(String gpioPortName, int direction, int edge){
        service = new PeripheralManagerService();
        this.gpioPortName = gpioPortName;
        this.edge = edge;
        this.direction = direction;

        this.listner = null;
        mHandler = new Handler();
    }

    /**
     * Configures the GPIO Port for output
     */
    public void ConfigurePort() {

        try {
            gpioPort = service.openGpio(this.gpioPortName);
            // Step 2. Configure as an output.
            gpioPort.setDirection(this.direction);

            //TODO: Figure out why the Edgeis not working
           // gpioPort.setEdgeTriggerType(this.edge);

            mHandler.post(mCallBackRunnable);
        }  catch (IOException e) {
            Log.e("Configure Port", "Error on PeripheralIO API", e);
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

    public static PeripheralManagerService getService() {
        return service;
    }

}
