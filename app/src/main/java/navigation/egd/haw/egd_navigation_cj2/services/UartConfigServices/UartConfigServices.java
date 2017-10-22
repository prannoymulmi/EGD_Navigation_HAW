package navigation.egd.haw.egd_navigation_cj2.services.UartConfigServices;

import android.util.Log;

import com.google.android.things.pio.UartDevice;

import java.io.IOException;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.IUartPortsConfigs;
import navigation.egd.haw.egd_navigation_cj2.constants.RaspberyPiPortsConstants;
import navigation.egd.haw.egd_navigation_cj2.services.PortAvailableCheckService;

/**
 * @author Prannoy
 * Created by prann on 10/22/2017.
 * https://developer.android.com/things/sdk/pio/uart.html
 */

//TODO: Configure UART into work for you according to this
public class UartConfigServices extends PortAvailableCheckService implements IUartPortsConfigs{

    private UartDevice mDevice;
    public UartConfigServices() {

    }

    //Must be more generic
    @Override
    public void confiugureUartPorts() {
        try {
            mDevice = service.openUartDevice(RaspberyPiPortsConstants.UART_PIN_8_TXD);
            mDevice.setBaudrate(115200);
            mDevice.setDataSize(8);
            mDevice.setParity(UartDevice.PARITY_NONE);
            mDevice.setStopBits(1);
        } catch (IOException e) {
            Log.w("TEST", "Unable to access UART device", e);
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
