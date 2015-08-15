package com.example.funkym0nk3y.sensors;

import android.app.Activity;
import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SensorManager smanager = (SensorManager) this.getSystemService(SENSOR_SERVICE);

    List<Sensor> sensors = smanager.getSensorList(Sensor.TYPE_ALL);
    ArrayList<String> sensoresLista = new ArrayList<>();

    for ( int i=0; i<sensors.size(); i++ ) {
      sensoresLista.add(((Sensor)sensors.get(i)).getName());
    }

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensoresLista);
    setListAdapter(adapter);
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
    if ( id == R.id.action_settings ) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
