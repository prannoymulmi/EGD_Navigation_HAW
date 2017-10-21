package navigation.egd.haw.egd_navigation_cj2.constants;

import com.google.android.things.pio.Gpio;

/**
 * Contains the pins and config constanst which are required to setup a GPIO port in Rpi 3
 * @author Prannoy
 * Created by prann on 10/20/2017.
 */

public class RaspberyPiPortsConstants {


    /**
     * Empty constructor so that the attributes cannot be initialized
     */
    public RaspberyPiPortsConstants() {

    }

    /**
     * Naming Convention Description <PinType>_Pin_<PinNumberInBoard>_<ExtraInfo>
     * https://developer.android.com/things/hardware/raspberrypi-io.html
     */

    //----------GPIO Ports----------------------------
    public static final String GPIO_PIN_7 ="BCM4";
     public static final String GPIO_PIN_11 ="BCM17";
     public static final String GPIO_PIN_13 ="BCM27";
     public static final String GPIO_PIN_15 ="BCM22";
     public static final String GPIO_PIN_16 ="BCM23";
     public static final String GPIO_PIN_18 ="BCM24";
     public static final String GPIO_PIN_22 ="BCM25";
     public static final String GPIO_PIN_29 ="BCM5";
     public static final String GPIO_PIN_31 ="BCM6";
     public static final String GPIO_PIN_32 ="BCM12";
     public static final String GPIO_PIN_36 ="BCM16";
     public static final String GPIO_PIN_37 ="BCM26";

    //------------UART port-----------------
    public static final String UART_PIN_8_TXD ="BCM14";
    public static final String UART_PIN_10_RXD ="BCM15";

    //------------GPIO Config Constants----------
    public static final int GPIO_EDGE_FALLING = Gpio.EDGE_FALLING;
    public static final int GPIO_EDGE_RISING = Gpio.EDGE_RISING;
    public static final int GPIO_EDGE_BOTH = Gpio.EDGE_BOTH;
    public static final int GPIO_EDGE_NONE = Gpio.EDGE_NONE;

    public static final int GPIO_DIRECTION_IN = Gpio.DIRECTION_IN;
    public static final int GPIO_DIRECTION_OUT_INITIALLY_LOW= Gpio.DIRECTION_OUT_INITIALLY_LOW;
    public static final int GPIO_DIRECTION_OUT_INITIALLY_HIGH= Gpio.DIRECTION_OUT_INITIALLY_HIGH;

}
