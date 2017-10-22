package navigation.egd.haw.egd_navigation_cj2.services.PortConfigServices;

import com.google.android.things.pio.PeripheralManagerService;

import java.util.List;

import navigation.egd.haw.egd_navigation_cj2.Exceptions.GPIOPortsNotAvailableException;

/**
 * @author Prannoy
 * @Description This class is responsible to check if the port are available
 * https://developer.android.com/things/sdk/pio/gpio.html
 * Created by prann on 10/22/2017.
 */

public class PortAvailableCheckService {
    protected static PeripheralManagerService service;
    protected List<String> availablePortList;
    protected List<String> uartDeviceList;

    public PortAvailableCheckService(){
        service = new PeripheralManagerService();
        this.availablePortList = service.getGpioList();
        this.uartDeviceList = service.getUartDeviceList();
    }

    public List<String> getGpioAvailablePorts() throws GPIOPortsNotAvailableException {
        if(this.availablePortList.isEmpty()){
            throw new GPIOPortsNotAvailableException("No GPIO port available on this device.");
        }
        return this.availablePortList;
    }

    public List<String> getUartAvailableList() throws GPIOPortsNotAvailableException {
        if(this.uartDeviceList.isEmpty()){
            throw new GPIOPortsNotAvailableException("No UART port available on this device.");
        }
        return this.uartDeviceList;
    }



    //------------------getters-----------------
    public static PeripheralManagerService getService() {
        return service;
    }

}
