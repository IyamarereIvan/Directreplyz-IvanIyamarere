package com.example.directreply;

import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.RemoteInput;

public class NotificationReceivers extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_receivers);
        textView=(TextView) findViewById(R.id.received);
        Bundle remoteInput = RemoteInput.getResultsFromIntent(getIntent());

        //if there is some input
        if (remoteInput != null) {
            String name = remoteInput.getCharSequence(MainActivity.NOTIFICATION_REPLY).toString();
            textView.setText(name);

        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(MainActivity.NOTIFICATION_ID);

    }
}
