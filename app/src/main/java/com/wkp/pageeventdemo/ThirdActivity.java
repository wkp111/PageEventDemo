package com.wkp.pageeventdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wkp.pageevent.base.EventAppCompatActivity;
import com.wkp.pageevent.info.Event;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by wkp111 on 2020/5/7.
 */

public class ThirdActivity extends EventAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    @Override
    public boolean initPageStickEvent() {
        addPageStickEvent(MainActivity.class);
        return true;
    }

    @Override
    public boolean onStickEvent(@NonNull Event event) {
        int eventType = event.getEventType();
        Bundle eventParams = event.getEventParams();
        if (eventType == Constants.STICK_EVENT_FIRST) {
            String string = eventParams.getString(Constants.STICK_EVENT_PARAM_FIRST);
            Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
            return true;
        } else if (eventType == Constants.STICK_EVENT_SECOND) {
            String string = eventParams.getString(Constants.STICK_EVENT_PARAM_SECOND);
            Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
        }
        return super.onStickEvent(event);
    }

    public void startSecond(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
