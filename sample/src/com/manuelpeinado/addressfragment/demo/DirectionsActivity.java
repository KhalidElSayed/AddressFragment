package com.manuelpeinado.addressfragment.demo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class DirectionsActivity extends SherlockFragmentActivity implements OnClickListener {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
        mMap = mapFragment.getMap();
        if (!ensureMapIsReady()) {
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
    }

    private boolean ensureMapIsReady() {
        if (mMap == null) {
            Toast.makeText(this, R.string.could_not_load_map, Toast.LENGTH_LONG).show();
            finish();
            return false;
        }
        return true;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.activity_directions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_directions) {
            showDirectionsDialog();
        }
        return true;
    }

    private void showDirectionsDialog() {
        DirectionsDialog.newInstance().show(getSupportFragmentManager(), "directionsDlg");
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        
    }
}