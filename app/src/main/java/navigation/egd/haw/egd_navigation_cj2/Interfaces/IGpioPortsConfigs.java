package navigation.egd.haw.egd_navigation_cj2.Interfaces;

/**
 * This interface has methods which is required when configuring and closing GPIO ports
 * @author prannoy
 * Created by prann on 10/21/2017.
 */

public interface IGpioPortsConfigs {
    void confiugureGpioPorts();
    void closeGpioPorts();
}
