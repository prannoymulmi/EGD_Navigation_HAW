package navigation.egd.haw.egd_navigation_cj2.services.GPIOConfigServices;

import com.google.android.things.pio.PeripheralManagerService;

import java.util.List;

import navigation.egd.haw.egd_navigation_cj2.Exceptions.GPIOPortsNotAvailableException;

/**
 * @author Prannoy
 * @Description This class is responsible to check if the port are available
 * https://developer.android.com/things/sdk/pio/gpio.html
 * Created by prann on 10/22/2017.
 */

public class GPIOPortAvailableCheckService {

    protected static PeripheralManagerService service;
    protected List<String> availablePortList;

    public GPIOPortAvailableCheckService(){
        service = new PeripheralManagerService();
        this.availablePortList = service.getGpioList();
    }

    public List<String> getAvailablePorts() throws GPIOPortsNotAvailableException {
        if(this.availablePortList.isEmpty()){
            throw new GPIOPortsNotAvailableException("No GPIO port available on this device.");
        }
        return this.availablePortList;
    }

    /**
     * Returns if the Given port name is free or not
     * @param portName
     * @return
     */
    public boolean isPortAvailable(String portName) throws GPIOPortsNotAvailableException {
         if(this.availablePortList.contains(portName)) {
             return true;
         } else {
             throw new GPIOPortsNotAvailableException(portName + " port is not available on this device.");
         }
    }


    //------------------getters-----------------
    public static PeripheralManagerService getService() {
        return service;
    }

}
