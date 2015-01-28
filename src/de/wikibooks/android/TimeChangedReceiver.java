package de.wikibooks.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TimeChangedReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (action.equals(Intent.ACTION_TIME_CHANGED)) {
			Toast.makeText(context, "Zeit Changed", Toast.LENGTH_LONG).show();
		} else if (action.equals(Intent.ACTION_TIMEZONE_CHANGED)) {
			showTimezone(context, intent.getStringExtra("time-zone"));
		}
	}

	private void showTimezone(Context context, String msg) {
		Intent intent = new Intent("de.wikibooks.android.TIMEZONEACTIVITY");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("Message", msg);
		context.startActivity(intent);
	}

}
