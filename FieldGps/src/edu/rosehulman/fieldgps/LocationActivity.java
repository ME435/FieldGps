package edu.rosehulman.fieldgps;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Example app that shows the usage of the FieldGps class.
 * 
 * @author fisherds@gmail.com (Dave Fisher)
 * 
 */
public class LocationActivity extends Activity implements FieldGpsListener {

  /** Field GPS instance that gives field feet and field bearings. */
  private FieldGps mFieldGps;

  /** Text views that will be updated. */
  private TextView mXTextView, mYTextView, mBearingTextView,
      mCounterTextView, mGpsLocationTextView, mGpsAccuracyTextView, mSpeedTextView;

  /** Counter for the number of updates received. */
  private long mUpdatesCounter = 0;

  /** Force the screen and CPU to high power mode always. */
  private PowerManager.WakeLock mWakeLock;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_location);
    
    PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
    mWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE, "Unused TAG");
    
    mXTextView = (TextView) findViewById(R.id.x_textview);
    mYTextView = (TextView) findViewById(R.id.y_textview);
    mBearingTextView = (TextView) findViewById(R.id.bearing_textview);
    mCounterTextView = (TextView) findViewById(R.id.counter_textview);
    mGpsLocationTextView = (TextView) findViewById(R.id.gps_location_textview);
    mGpsAccuracyTextView = (TextView) findViewById(R.id.accuracy_textview);
    mSpeedTextView = (TextView) findViewById(R.id.speed_textview);
    
    mFieldGps = new FieldGps(this);
    Button setAsOriginButton = (Button) findViewById(R.id.set_as_origin_button);
    setAsOriginButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        mFieldGps.setCurrentLocationAsOrigin();
      }
    });
    Button setAsXAxisLocationButton = (Button) findViewById(R.id.set_as_x_axis_location);
    setAsXAxisLocationButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        mFieldGps.setCurrentLocationAsLocationOnXAxis();
      }
    });
  }
  
  @Override
  protected void onStart() {
    super.onStart();
    mWakeLock.acquire();
    mFieldGps.requestLocationUpdates(this); // Start receiving GPS Provider updates.
    mXTextView.setText("Waiting for first fix");
    mYTextView.setText("Waiting for first fix");
    mBearingTextView.setText("Waiting for bearing");
  }
  
  @Override
  protected void onStop() {
    super.onStop();
    mWakeLock.release();
    mFieldGps.removeUpdates(); // Stop receiving GPS Provider updates.
  }

  public void onLocationChanged(double x, double y, double heading, Location location) {
    mUpdatesCounter++;
    mCounterTextView.setText("" + mUpdatesCounter);
    mXTextView.setText(String.format(" %.1f ft", x));
    mYTextView.setText(String.format(" %.1f ft", y));
    if (heading < 180.0 && heading > -180.0) {
      mBearingTextView.setText(String.format("%.1fº", heading));
    } else {
      mBearingTextView.setText("---");
    }
    // Add some optional extra data.
    mGpsLocationTextView.setText(
        String.format("%.6f,%.6f", location.getLatitude(), location.getLongitude())); 
    if (location.hasAccuracy()) {
      mGpsAccuracyTextView.setText(String.format("%.1f ft", location.getAccuracy() * FieldGps.FEET_PER_METER));          
    } else {
      mGpsAccuracyTextView.setText("---");    
    }
    if (location.hasSpeed()) {
      // You could also display the speed (and determine if it's realistic).
      mSpeedTextView.setText(
          String.format("%.2f ft/s", location.getSpeed() * FieldGps.FEET_PER_METER));
    }
  }
}
