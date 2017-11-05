package navigation.egd.haw.egd_navigation_cj2.Interfaces;

/**
 * Created by prann on 10/22/2017.
 */

public interface IUartPortsConfigs {
    void confiugureUartPorts();
    void openUartPort();  // starting communication through uart (created by ahsan on 11/05/2017)
    void closeUartPorts();
}
