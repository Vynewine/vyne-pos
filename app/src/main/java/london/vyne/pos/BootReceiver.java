package london.vyne.pos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

    public static final String TAG = BootReceiver.class.getName();

    @Override
    public void onReceive(final Context context, final Intent intent) {
        //TODO: Re-Register devise based on advise from:
        //https://blog.pushbullet.com/2014/02/12/keeping-google-cloud-messaging-for-android-working-reliably-techincal-post/
        Log.d(TAG, "onReceive called");
    }
}
