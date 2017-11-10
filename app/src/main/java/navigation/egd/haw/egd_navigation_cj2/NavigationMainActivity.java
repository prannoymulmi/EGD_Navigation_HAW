package navigation.egd.haw.egd_navigation_cj2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;
import navigation.egd.haw.egd_navigation_cj2.controllers.GpioPortsConfigs;
import navigation.egd.haw.egd_navigation_cj2.dagger.NavigationMainActivity.DaggerNavigationMainActivityComponent;
import navigation.egd.haw.egd_navigation_cj2.dagger.NavigationMainActivity.NavigationMainActivityModule;


public class NavigationMainActivity extends AppCompatActivity {

    @Inject INavigationManager manager;
    //TODO: remove the concrete implmentation for the GPIO ports
    @Inject GpioPortsConfigs demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);

        //This is just a demo for using the GPIO ports
        //this.demo = new GpioPortsConfigs();
        //this.demo.confiugureGpioPorts();

        Context context = this;
        DaggerNavigationMainActivityComponent.builder()
                .navigationMainActivityModule(new NavigationMainActivityModule(context))
                .build()
                .inject(this);

        //TODO: This should be later on triggered on an interrupt or something
        this.manager.run();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //this.demo.closeGpioPorts();
    }
}
