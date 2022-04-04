package com.example.pressuresensorapp;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pressuresensorapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //********** Mariam: Parse data read through BLE and send to UI *************///
    //TO DO:
    //Setup Loop
    //Get the id of the view objects

    public void messageRead(Message msg) {
        String arduinoMsg = msg.obj.toString(); //read message from arduino
        char[] separator = new char[] {'@'};
        String[] splitter = arduinoMsg.Split(separator, 9); //Split the string, values are separated by '@'

        //Assign split string to corresponding values
        float[] sensorData = new float[9];
        for (int i = 0; i < 9; i++)
        {
            sensorData[i] = float.parseFloat(splitter[i]);
        }
        Thread.Sleep(500); //Wait 500 milliseconds before doing anything, matches with the Arduino
        //delay
    }

    public void handleDisplay(int[] sensorData) {
        //change color of view objects based on sensor readings
        //default color is yellow
        //sensor_1 = view.findViewById(R.id.('id_name'));
        for(int i = 0; i < sensorData.Length; i++)
        {
        if (sensorData[i] >= 600) {
            switch (i) {
                case 0:
                    sensor_1.setBackgroundColor(getResources().getColor(R.color.orange));
                    break;
                case 1:
                    sensor_2.setBackgroundColor(getResources().getColor(R.color.orange));
                    break;
                case 2:
                    sensor_3.setBackgroundColor(getResources().getColor(R.color.orange));
                    break;
                case 3:
                    sensor_4.setBackgroundColor(getResources().getColor(R.color.orange));
                    break;
                case 4:
                    sensor_5.setBackgroundColor(getResources().getColor(R.color.orange));
                    break;
                case 5:
                    sensor_6.setBackgroundColor(getResources().getColor(R.color.orange));
                    break;
                case 6:
                    sensor_7.setBackgroundColor(getResources().getColor(R.color.orange));
                    break;
                case 7:
                    sensor_8.setBackgroundColor(getResources().getColor(R.color.orange));
                    break;
                case 8:
                    sensor_9.setBackgroundColor(getResources().getColor(R.color.orange));
                    break;
            }
        }
        if (sensorData[i] >= 1000) {
            switch (i) {
                case 0:
                    sensor_1.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 1:
                    sensor_2.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 2:
                    sensor_3.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 3:
                    sensor_4.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 4:
                    sensor_5.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 5:
                    sensor_6.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 6:
                    sensor_7.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 7:
                    sensor_8.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 8:
                    sensor_9.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
            }
        }
    }
}