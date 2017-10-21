package navigation.egd.haw.egd_navigation_cj2.listeners;

import com.google.android.things.pio.Gpio;
import java.io.IOException;

/**
 * This is a listner which will be called to a specific port
 * https://guides.codepath.com/android/Creating-Custom-Listeners#why-listeners
 * Following the Observer pattern for MVC
 * @author prannoy
 * Created by prann on 10/20/2017.
 */

public interface IGpioPortConfigCallbackListener {
    public void portCallback(Gpio gpioPort) throws IOException;
}
