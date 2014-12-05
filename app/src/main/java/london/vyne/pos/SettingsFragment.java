package london.vyne.pos;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        SharedPreferences preferences = getPreferenceScreen().getSharedPreferences();
        EditTextPreference editTextPref = (EditTextPreference) findPreference(getString(R.string.pref_device_key));
        String deviceKey = preferences.getString(getString(R.string.pref_device_key), getString(R.string.pref_device_description));

        if (deviceKey.isEmpty()) {
            deviceKey = getString(R.string.pref_device_description);
        }

        editTextPref.setSummary(deviceKey);

    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        if (key.equals(getString(R.string.pref_device_key))) {
            Preference connectionPref = findPreference(key);

            String deviceKey = sharedPreferences.getString(key, getString(R.string.pref_device_description));

            if (deviceKey.isEmpty()) {
                deviceKey = getString(R.string.pref_device_description);
            }

            connectionPref.setSummary(deviceKey);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

}