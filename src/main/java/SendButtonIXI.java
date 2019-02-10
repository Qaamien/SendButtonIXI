import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iota.ict.ixi.Ixi;
import org.iota.ict.ixi.IxiModule;
import org.iota.ict.model.TransactionBuilder;


//                                           USE AT YOUR OWN RISK!
//                      I am not responsible for any damage caused by running this software.
//            Please use it at your own risk! If you don't understand what you are doing, do not use it.

//          This is reference IXI module how you can use GPIOs of Raspberry Pi to interact with ICT network.
//    This is just simple example, if button is pushed and pin reads HIGH because of that it will send tx to tangle


public class SendButtonIXI extends IxiModule {



    private final static Logger LOGGER = LogManager.getLogger(SendButtonIXI.class);

    final GpioController gpio = GpioFactory.getInstance();  // Create GPIO controller

    // Set GPIOs as input pins
    private final GpioPinDigitalInput buttonOn = gpio.provisionDigitalInputPin(
            RaspiPin.GPIO_02, "ledOn", PinPullResistance.PULL_DOWN);

    private final GpioPinDigitalInput buttonOff = gpio.provisionDigitalInputPin(
            RaspiPin.GPIO_03, "ledOff", PinPullResistance.PULL_DOWN);

    public SendButtonIXI(Ixi ixi) {
        super(ixi);
    }


    public void run() {

        LOGGER.info("Send Button IXI module started!");

        // Listen pins and sending transactions to address if pin goes HIGH

        buttonOn.addListener((GpioPinListenerDigital) event -> {

            if (event.getState().isHigh()) {

                final TransactionBuilder t = new TransactionBuilder();
                t.address = "";
                t.asciiMessage("ON");
                ixi.submit(t.buildWhileUpdatingTimestamp());


                LOGGER.info("Button ON is pushed and tx sended to ICT network!");

            }



        });

        buttonOff.addListener((GpioPinListenerDigital) event -> {


            if (event.getState().isHigh()) {



                final TransactionBuilder t = new TransactionBuilder();
                t.address = "";
                t.asciiMessage("OFF");
                ixi.submit(t.buildWhileUpdatingTimestamp());

                LOGGER.info("Button OFF is pushed and tx sended to ICT network!");

            }



        });

    }
}


