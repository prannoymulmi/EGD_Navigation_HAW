package navigation.egd.haw.egd_navigation_cj2.Exceptions;

/**
 * @author Prannoy
 * @Description An Exception class which is to be thrown when the GPIO port is wrongly congigured
 * Created by prann on 10/22/2017.
 */

public class GpioPortDirectionException extends Exception {
    public GpioPortDirectionException(String message){
        super(message);
    }
}
