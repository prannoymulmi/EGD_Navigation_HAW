package navigation.egd.haw.egd_navigation_cj2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import navigation.egd.haw.egd_navigation_cj2.controllers.GpioPortsConfigs;
import navigation.egd.haw.egd_navigation_cj2.controllers.NavigationManger;
import navigation.egd.haw.egd_navigation_cj2.dagger.DirectionAPI.DirectionComponent;

public class NavigationMainActivity extends AppCompatActivity {

    NavigationManger manager;
    GpioPortsConfigs demo;
    DirectionComponent directionComponent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);

        //This is just a demo for using the GPIO ports
        //this.demo = new GpioPortsConfigs();
        //this.demo.confiugureGpioPorts();

        this.manager = new NavigationManger();
        this.manager.run();

    }

    public DirectionComponent getDirectionComponent () {
        return directionComponent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //this.demo.closeGpioPorts();
    }
}
