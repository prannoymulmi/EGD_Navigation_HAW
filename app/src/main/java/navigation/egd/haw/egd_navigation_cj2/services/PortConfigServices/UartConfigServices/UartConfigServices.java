package navigation.egd.haw.egd_navigation_cj2.services.PortConfigServices.UartConfigServices;

import android.util.Log;

import com.google.android.things.pio.PeripheralManagerService;
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
    private static String UART_DEVICE_NAME;

    public UartConfigServices(String uartPortName, int baudRate, int dataSize, int stopBits, String UART_DEVICE_NAME) {
        this.uartPortName = uartPortName;
        this.baudRate= baudRate;
        this.dataSize = dataSize;
        this.stopBits = stopBits;
        this.UART_DEVICE_NAME = UART_DEVICE_NAME;
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


    public void writeUartData(UartDevice uart) throws IOException {
        byte[] buffer = {};
        int count = uart.write(buffer, buffer.length);
        Log.d("Test: UART writing", "Wrote " + count + " bytes to peripheral");
    }
    public void readUartBuffer(UartDevice uart) throws IOException {
        // Maximum amount of data to read at one time
        final int maxCount = dataSize;
        byte[] buffer = new byte[maxCount];

        int count;
        while ((count = uart.read(buffer, buffer.length)) > 0) {
            Log.d("Test: UART listening", "Read " + count + " bytes from peripheral");
        }
    }


    public void openUartPort() {

        // Attempt to access the UART device
        try {
            PeripheralManagerService manager = new PeripheralManagerService();
            mDevice = manager.openUartDevice(UART_DEVICE_NAME);
        } catch (IOException e) {
            Log.w("TEST: UART open", "Unable to access UART device", e);
        }
    }
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
