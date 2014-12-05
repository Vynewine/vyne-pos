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

        EditTextPreference deviceKeyPref = (EditTextPreference) findPreference(getString(R.string.pref_device_key));
        EditTextPreference urlPref = (EditTextPreference) findPreference(getString(R.string.pref_vyne_url_key));

        String deviceKey = preferences.getString(getString(R.string.pref_device_key), getString(R.string.pref_device_description));
        String url = preferences.getString(getString(R.string.pref_vyne_url_key), getString(R.string.pref_vyne_url_description));


        if (deviceKey.isEmpty()) {
            deviceKey = getString(R.string.pref_device_description);
        }

        if (url.isEmpty()) {
            url = getString(R.string.pref_vyne_url_description);
        }

        deviceKeyPref.setSummary(deviceKey);
        urlPref.setSummary(url);

    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        Preference preference = findPreference(key);
        String defaultValue = "";

        if (key.equals(getString(R.string.pref_device_key))) {
            defaultValue = getString(R.string.pref_device_description);
        } else if (key.equals(getString(R.string.pref_vyne_url_key))) {
            defaultValue = getString(R.string.pref_vyne_url_description);
        }

        String value = sharedPreferences.getString(key, defaultValue);

        if (value.isEmpty()) {
            value = defaultValue;
        }

        preference.setSummary(value);
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