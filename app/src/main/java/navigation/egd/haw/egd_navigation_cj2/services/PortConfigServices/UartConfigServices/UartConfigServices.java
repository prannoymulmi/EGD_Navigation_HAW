package navigation.egd.haw.egd_navigation_cj2.services.PortConfigServices.UartConfigServices;

import android.util.Log;

import com.google.android.things.pio.UartDevice;

import java.io.IOException;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.IUartPortsConfigs;
import navigation.egd.haw.egd_navigation_cj2.services.PortConfigServices.PortAvailableCheckService;

/**
 * @author Prannoy
 * Created by prann on 10/22/2017.
 * https://developer.android.com/things/sdk/pio/uart.html
 */

//TODO: Configure UART into work for you according to this
public class UartConfigServices extends PortAvailableCheckService implements IUartPortsConfigs{

    private UartDevice mDevice;
    private String uartPortName;
    private int baudRate;
    private int dataSize;
    private int stopBits;

    public UartConfigServices(String uartPortName, int baudRate, int dataSize, int stopBits) {
        this.uartPortName = uartPortName;
        this.baudRate= baudRate;
        this.dataSize = dataSize;
        this.stopBits = stopBits;
    }

    //Must be more generic
    @Override
    public void confiugureUartPorts() {
        try {
            mDevice = service.openUartDevice(this.uartPortName);
            mDevice.setBaudrate(this.baudRate);
            mDevice.setDataSize(baudRate);
            mDevice.setParity(UartDevice.PARITY_NONE);
            mDevice.setStopBits(this.stopBits);
        } catch (IOException e) {
            Log.w("TEST", "Unable to access UART device", e);
        }
    }

    /**
     * TODO: Reading and wrting methods missing
     */

    @Override
    public void closeUartPorts() {
        if (mDevice != null) {
            try {
                mDevice.close();
                mDevice = null;
            } catch (IOException e) {
                Log.w("TEST", "Unable to close UART device", e);
            }
        }
    }
}
