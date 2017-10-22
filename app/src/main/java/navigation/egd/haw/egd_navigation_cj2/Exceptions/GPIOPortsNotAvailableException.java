package navigation.egd.haw.egd_navigation_cj2.Exceptions;

/**
 * @author Prannoy
 * @Decription An Exception class which is to be thrown when there are no available GPIO Ports
 */


public class GPIOPortsNotAvailableException extends Exception {

    public GPIOPortsNotAvailableException(String message) {
        super((message));
    }
}
