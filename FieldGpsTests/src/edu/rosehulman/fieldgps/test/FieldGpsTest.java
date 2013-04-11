package edu.rosehulman.fieldgps.test;

import junit.framework.TestCase;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import edu.rosehulman.fieldgps.FieldGps;
import edu.rosehulman.fieldgps.FieldGpsListener;

public class FieldGpsTest extends TestCase implements FieldGpsListener {
	
	public static final String TAG = FieldGpsTest.class.getSimpleName();
	private static final double EPLISON_LAT_LONG = 9.0;
	private static final double EPLISON_BEARING = 5.0;
	private static final double BOTTOM_50_LAT = 39.474746;
	private static final double BOTTOM_50_LONG =  -87.367026;
	private static final double CENTER_50_LAT = 39.474946; 
	private static final double CENTER_50_LONG = -87.366885;
	private static final double TOP_50_LAT = 39.475124; 
	private static final double TOP_50_LONG = -87.366745;
	private static final double BOTTOM_WEST_0_LAT = 39.474954; 
	private static final double BOTTOM_WEST_0_LONG = -87.367486;
	private static final double CENTER_WEST_0_LAT = 39.475144; 
	private static final double CENTER_WEST_0_LONG = -87.367344;
	private static final double TOP_WEST_0_LAT = 39.475329; 
	private static final double TOP_WEST_0_LONG = -87.367207;
	private static final double BOTTOM_EAST_0_LAT = 39.474539;
	private static final double BOTTOM_EAST_0_LONG = -87.366566;
	private static final double CENTER_EAST_0_LAT = 39.474733;
	private static final double CENTER_EAST_0_LONG = -87.366424;
	private static final double TOP_EAST_0_LAT = 39.474920;
	private static final double TOP_EAST_0_LONG = -87.366285;
	
	private double mExpectedX, mExpectedY, mExpectedHeading;
	private FieldGps mCenterEastField = new FieldGps(this, CENTER_50_LAT, CENTER_50_LONG,
			CENTER_EAST_0_LAT, CENTER_EAST_0_LONG);
	private FieldGps mBottomWestUpField = new FieldGps(this, BOTTOM_WEST_0_LAT, BOTTOM_WEST_0_LONG,
			TOP_WEST_0_LAT, TOP_WEST_0_LONG);

	protected void setUp() throws Exception {
		super.setUp();
	}
	// *************** Test 8 points around the center ******************
	public void testTop50CenterEastField() {
		Log.d(TAG, "Top 50 CenterEastField");
		Location top50 = new Location(LocationManager.GPS_PROVIDER);
		top50.setLatitude(TOP_50_LAT);
		top50.setLongitude(TOP_50_LONG);
		mExpectedX = 0.0;
		mExpectedY = 80.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mCenterEastField.dispatchOnLocationChangedEvent(top50);
	}
	public void testBottom50CenterEastField() {
		Log.d(TAG, "Bottom 50 CenterEastField");
		Location bottom50 = new Location(LocationManager.GPS_PROVIDER);
		bottom50.setLatitude(BOTTOM_50_LAT);
		bottom50.setLongitude(BOTTOM_50_LONG);
		mExpectedX = 0.0;
		mExpectedY = -80.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mCenterEastField.dispatchOnLocationChangedEvent(bottom50);
	}
	public void testTopWest0CenterEastField() {
		Log.d(TAG, "Top West 0 CenterEastField");
		Location topWest0 = new Location(LocationManager.GPS_PROVIDER);
		topWest0.setLatitude(TOP_WEST_0_LAT);
		topWest0.setLongitude(TOP_WEST_0_LONG);
		mExpectedX = -150.0;
		mExpectedY = 80.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mCenterEastField.dispatchOnLocationChangedEvent(topWest0);
	}
	
	public void testCenterWest0CenterEastField() {
		Log.d(TAG, "Center West 0 CenterEastField");
		Location centerWest0 = new Location(LocationManager.GPS_PROVIDER);
		centerWest0.setLatitude(CENTER_WEST_0_LAT);
		centerWest0.setLongitude(CENTER_WEST_0_LONG);
		mExpectedX = -150.0;
		mExpectedY = 0.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mCenterEastField.dispatchOnLocationChangedEvent(centerWest0);
	}
	public void testBottomWest0CenterEastField() {
		Log.d(TAG, "Bottom West 0 CenterEastField");
		Location bottomWest0 = new Location(LocationManager.GPS_PROVIDER);
		bottomWest0.setLatitude(BOTTOM_WEST_0_LAT);
		bottomWest0.setLongitude(BOTTOM_WEST_0_LONG);
		mExpectedX = -150.0;
		mExpectedY = -80.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mCenterEastField.dispatchOnLocationChangedEvent(bottomWest0);
	}
	public void testTopEast0CenterEastField() {
		Log.d(TAG, "Top East 0 CenterEastField");
		Location topEast0 = new Location(LocationManager.GPS_PROVIDER);
		topEast0.setLatitude(TOP_EAST_0_LAT);
		topEast0.setLongitude(TOP_EAST_0_LONG);
		mExpectedX = 150.0;
		mExpectedY = 80.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mCenterEastField.dispatchOnLocationChangedEvent(topEast0);
	}
	public void testCenterEast0CenterEastField() {
		Log.d(TAG, "Center East 0 CenterEastField");
		Location centerEast0 = new Location(LocationManager.GPS_PROVIDER);
		centerEast0.setLatitude(CENTER_EAST_0_LAT);
		centerEast0.setLongitude(CENTER_EAST_0_LONG);
		mExpectedX = 150.0;
		mExpectedY = 0.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mCenterEastField.dispatchOnLocationChangedEvent(centerEast0);
	}
	public void testBottomEast0CenterEastField() {
		Log.d(TAG, "Bottom East 0 CenterEastField");
		Location bottomEast0 = new Location(LocationManager.GPS_PROVIDER);
		bottomEast0.setLatitude(BOTTOM_EAST_0_LAT);
		bottomEast0.setLongitude(BOTTOM_EAST_0_LONG);
		mExpectedX = 150.0;
		mExpectedY = -80.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mCenterEastField.dispatchOnLocationChangedEvent(bottomEast0);
	}
	
	//********************************  Bearings ******************

	public void testBearingNorthCenterEastField() {
		Log.d(TAG, "Bearing North CenterEastField");
		Location center50 = new Location(LocationManager.GPS_PROVIDER);
		center50.setLatitude(CENTER_50_LAT);
		center50.setLongitude(CENTER_50_LONG);
		center50.setBearing(0);
		mExpectedX = 0.0;
		mExpectedY = 0.0;
		mExpectedHeading = 120.0;
		mCenterEastField.dispatchOnLocationChangedEvent(center50);
	}
	public void testBearingEastCenterEastField() {
		Log.d(TAG, "Bearing East CenterEastField");
		Location center50 = new Location(LocationManager.GPS_PROVIDER);
		center50.setLatitude(CENTER_50_LAT);
		center50.setLongitude(CENTER_50_LONG);
		center50.setBearing(90);
		mExpectedX = 0.0;
		mExpectedY = 0.0;
		mExpectedHeading = 30.0;
		mCenterEastField.dispatchOnLocationChangedEvent(center50);
	}
	public void testBearingSouthCenterEastField() {
		Log.d(TAG, "Bearing East CenterEastField");
		Location center50 = new Location(LocationManager.GPS_PROVIDER);
		center50.setLatitude(CENTER_50_LAT);
		center50.setLongitude(CENTER_50_LONG);
		center50.setBearing(180);
		mExpectedX = 0.0;
		mExpectedY = 0.0;
		mExpectedHeading = -60.0;
		mCenterEastField.dispatchOnLocationChangedEvent(center50);
	}
	public void testBearingWestCenterEastField() {
		Log.d(TAG, "Bearing West CenterEastField");
		Location center50 = new Location(LocationManager.GPS_PROVIDER);
		center50.setLatitude(CENTER_50_LAT);
		center50.setLongitude(CENTER_50_LONG);
		center50.setBearing(270);
		mExpectedX = 0.0;
		mExpectedY = 0.0;
		mExpectedHeading = -150.0;
		mCenterEastField.dispatchOnLocationChangedEvent(center50);
	}
	public void testBearingWest2CenterEastField() {
		Log.d(TAG, "Bearing West 2 CenterEastField");
		Location center50 = new Location(LocationManager.GPS_PROVIDER);
		center50.setLatitude(CENTER_50_LAT);
		center50.setLongitude(CENTER_50_LONG);
		center50.setBearing(-90);
		mExpectedX = 0.0;
		mExpectedY = 0.0;
		mExpectedHeading = -150.0;
		mCenterEastField.dispatchOnLocationChangedEvent(center50);
	}
	

	// *************** Test 9 points around the lower corner field ******************
	public void testTop50BottomWestUpField() {
		Log.d(TAG, "Top 50 BottomWestUpField");
		Location top50 = new Location(LocationManager.GPS_PROVIDER);
		top50.setLatitude(TOP_50_LAT);
		top50.setLongitude(TOP_50_LONG);
		top50.setBearing(0);
		mExpectedX = 160.0;
		mExpectedY = -150.0;
		mExpectedHeading = 30.0;
		mBottomWestUpField.dispatchOnLocationChangedEvent(top50);
	}
	public void testCenter50BottomWestUpField() {
		Log.d(TAG, "Top 50 BottomWestUpField");
		Location center50 = new Location(LocationManager.GPS_PROVIDER);
		center50.setLatitude(CENTER_50_LAT);
		center50.setLongitude(CENTER_50_LONG);
		center50.setBearing(90);
		mExpectedX = 80.0;
		mExpectedY = -150.0;
		mExpectedHeading = -60.0;
		mBottomWestUpField.dispatchOnLocationChangedEvent(center50);
	}
	public void testBottom50BottomWestUpField() {
		Log.d(TAG, "Bottom 50 BottomWestUpField");
		Location bottom50 = new Location(LocationManager.GPS_PROVIDER);
		bottom50.setLatitude(BOTTOM_50_LAT);
		bottom50.setLongitude(BOTTOM_50_LONG);
		bottom50.setBearing(180);
		mExpectedX = 0.0;
		mExpectedY = -150.0;
		mExpectedHeading = -150.0;
		mBottomWestUpField.dispatchOnLocationChangedEvent(bottom50);
	}
	public void testTopWest0BottomWestUpField() {
		Log.d(TAG, "Top West 0 BottomWestUpField");
		Location topWest0 = new Location(LocationManager.GPS_PROVIDER);
		topWest0.setLatitude(TOP_WEST_0_LAT);
		topWest0.setLongitude(TOP_WEST_0_LONG);
		topWest0.setBearing(270);
		mExpectedX = 160.0;
		mExpectedY = 0.0;
		mExpectedHeading = 120.0;
		mBottomWestUpField.dispatchOnLocationChangedEvent(topWest0);
	}
	
	public void testCenterWest0BottomWestUpField() {
		Log.d(TAG, "Center West 0 BottomWestUpField");
		Location centerWest0 = new Location(LocationManager.GPS_PROVIDER);
		centerWest0.setLatitude(CENTER_WEST_0_LAT);
		centerWest0.setLongitude(CENTER_WEST_0_LONG);
		centerWest0.setBearing(-90);
		mExpectedX = 80.0;
		mExpectedY = 0.0;
		mExpectedHeading = 120.0;
		mBottomWestUpField.dispatchOnLocationChangedEvent(centerWest0);
	}
	public void testBottomWest0BottomWestUpField() {
		Log.d(TAG, "Bottom West 0 BottomWestUpField");
		Location bottomWest0 = new Location(LocationManager.GPS_PROVIDER);
		bottomWest0.setLatitude(BOTTOM_WEST_0_LAT);
		bottomWest0.setLongitude(BOTTOM_WEST_0_LONG);
		mExpectedX = 0.0;
		mExpectedY = 0.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mBottomWestUpField.dispatchOnLocationChangedEvent(bottomWest0);
	}
	public void testTopEast0BottomWestUpField() {
		Log.d(TAG, "Top East 0 BottomWestUpField");
		Location topEast0 = new Location(LocationManager.GPS_PROVIDER);
		topEast0.setLatitude(TOP_EAST_0_LAT);
		topEast0.setLongitude(TOP_EAST_0_LONG);
		mExpectedX = 160.0;
		mExpectedY = -300.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mBottomWestUpField.dispatchOnLocationChangedEvent(topEast0);
	}
	public void testCenterEast0BottomWestUpField() {
		Log.d(TAG, "Center East 0 BottomWestUpField");
		Location centerEast0 = new Location(LocationManager.GPS_PROVIDER);
		centerEast0.setLatitude(CENTER_EAST_0_LAT);
		centerEast0.setLongitude(CENTER_EAST_0_LONG);
		mExpectedX = 80.0;
		mExpectedY = -300.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mBottomWestUpField.dispatchOnLocationChangedEvent(centerEast0);
	}
	public void testBottomEast0BottomWestUpField() {
		Log.d(TAG, "Bottom East 0 BottomWestUpField");
		Location bottomEast0 = new Location(LocationManager.GPS_PROVIDER);
		bottomEast0.setLatitude(BOTTOM_EAST_0_LAT);
		bottomEast0.setLongitude(BOTTOM_EAST_0_LONG);
		mExpectedX = 0.0;
		mExpectedY = -300.0;
		mExpectedHeading = FieldGps.NO_BEARING_AVAILABLE;
		mBottomWestUpField.dispatchOnLocationChangedEvent(bottomEast0);
	}
	
	// Callback for the FieldGpsListener
	public void onLocationChanged(double x, double y, double heading, Location location) {	
		Log.d(TAG, "Expected X = " + mExpectedX + "  actual x = " + x + "  Error = " + Math.abs(mExpectedX - x));
		Log.d(TAG, "Expected Y = " + mExpectedY + "  actual y = " + y + "  Error = " + Math.abs(mExpectedY - y));
		Log.d(TAG, "Expected heading = " + mExpectedHeading + "  actual heading = " + heading + "  Error = " + Math.abs(mExpectedHeading - heading));
		assertEquals(mExpectedX, x, EPLISON_LAT_LONG);
		assertEquals(mExpectedY, y, EPLISON_LAT_LONG);
		assertEquals(mExpectedHeading, heading, EPLISON_BEARING);
	}
}
