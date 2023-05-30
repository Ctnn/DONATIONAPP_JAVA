package com.eraybd.project;


import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import android.location.Location;
import android.widget.Toast;

public class activity_gmap extends AppCompatActivity implements OnMapReadyCallback {

    private final int FINE_PERMISSION_CODE = 1;
    private GoogleMap mMap;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmap);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();
    }

    public void getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, FINE_PERMISSION_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    mapFragment.getMapAsync(activity_gmap.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;


        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);

        //LatLng myLocation = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        LatLng istanbul = new LatLng(41.06117820058356, 28.909503760589427);
        LatLng ankara = new LatLng(39.93955052616844, 32.82216953650539);
        LatLng antalya = new LatLng(36.88674049604239, 30.697577131350723);
        LatLng izmir = new LatLng(38.42509672076776, 27.146628702849075);
        LatLng bursa = new LatLng(40.200911705418356, 29.060298795888638);

        LatLng center = new LatLng(39.378019569026264, 30.349293071560698);

        //mMap.addMarker(new MarkerOptions().position(myLocation).title("My Location"));
        mMap.addMarker(new MarkerOptions().position(istanbul).title("Acceptance Point, Istanbul"));
        mMap.addMarker(new MarkerOptions().position(ankara).title("Acceptance Point, Ankara"));
        mMap.addMarker(new MarkerOptions().position(antalya).title("Acceptance Point, Antalya"));
        mMap.addMarker(new MarkerOptions().position(izmir).title("Acceptance Point, Izmir"));
        mMap.addMarker(new MarkerOptions().position(bursa).title("Acceptance Point, Bursa"));

        String[] locations = getResources().getStringArray(R.array.location);

        if (activity_donate.getLocation().equalsIgnoreCase(locations[0]) ||
            activity_receive.getLocation().equalsIgnoreCase(locations[0])) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 6));
        }
        else if (activity_donate.getLocation().equalsIgnoreCase(locations[1]) ||
            activity_receive.getLocation().equalsIgnoreCase(locations[1])) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(istanbul, 15));
        }
        else if (activity_donate.getLocation().equalsIgnoreCase(locations[2]) ||
            activity_receive.getLocation().equalsIgnoreCase(locations[2]))  {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ankara, 15));
        }
        else if (activity_donate.getLocation().equalsIgnoreCase(locations[3]) ||
            activity_receive.getLocation().equalsIgnoreCase(locations[3]))  {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(antalya, 15));
        }
        else if (activity_donate.getLocation().equalsIgnoreCase(locations[4]) ||
            activity_receive.getLocation().equalsIgnoreCase(locations[4]))  {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(izmir, 15));
        }
        else if (activity_donate.getLocation().equalsIgnoreCase(locations[5]) ||
            activity_receive.getLocation().equalsIgnoreCase(locations[5])) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bursa, 15));
        }


    }

    //For Current Location
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FINE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
            else {
                Toast.makeText(this, "Location permission is denied, please allow the permission.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}