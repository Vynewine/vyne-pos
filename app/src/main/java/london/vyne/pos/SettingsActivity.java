package london.vyne.pos;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // get action bar
        ActionBar actionBar = getActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);

        populateSettings();
    }


    public void buttonSaveDeviceIdClick(View view) {

        final EditText editTextDeviceId = (EditText) findViewById(R.id.editTextDeviceId);

        Toast toast;

        SharedPreferences prefrerences = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = prefrerences.edit();
        editor.putString(MainActivity.DEVICE_ID, editTextDeviceId.getText().toString());
        if (editor.commit()) {
            toast = Toast.makeText(getApplicationContext(), "Device Id Saved successfully.",
                    Toast.LENGTH_LONG);
        } else {
            toast = Toast.makeText(getApplicationContext(), "There was a problem saving Device Id. Please try again.",
                    Toast.LENGTH_LONG);
        }

        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

    }

    private void populateSettings() {

        SharedPreferences prefrerences = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        final EditText editTextDeviceId = (EditText) findViewById(R.id.editTextDeviceId);
        editTextDeviceId.setText(prefrerences.getString(MainActivity.DEVICE_ID, ""));

    }
}