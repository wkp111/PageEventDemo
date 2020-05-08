package com.wkp.pageeventdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wkp.pageevent.base.EventAppCompatActivity;
import com.wkp.pageevent.helper.EventHelper;
import com.wkp.pageevent.info.Event;

public class MainActivity extends EventAppCompatActivity {

    private TextView mTvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTest = findViewById(R.id.tv_test);
        mTvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle eventParams = new Bundle();
                eventParams.putString(Constants.STICK_EVENT_PARAM_FIRST, "粘性事件first回调");
                EventHelper.onStickEvent(MainActivity.this, Constants.STICK_EVENT_FIRST, eventParams);
                Bundle eventParams1 = new Bundle();
                eventParams1.putString(Constants.STICK_EVENT_PARAM_SECOND, "粘性事件second回调");
                EventHelper.onStickEvent(MainActivity.this, Constants.STICK_EVENT_SECOND, eventParams1);
                startActivity(new Intent(MainActivity.this, ThirdActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventHelper.release();
    }

    @Override
    protected boolean initPageEvent() {
        addPageEvent(SecondActivity.class);
        return true;
    }

    @Override
    public void onEvent(@NonNull Event event) {
        int eventType = event.getEventType();
        Bundle eventParams = event.getEventParams();
        // 处理开始回调
        if (eventType == Constants.EVENT_TYPE_START) {
            if (eventParams != null) {
                String string = eventParams.getString(Constants.EVENT_PARAM_START);
                Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
            }
            mTvTest.getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Bundle eventParams = new Bundle();
                    eventParams.putString(Constants.EVENT_PARAM_END, "结束普通事件回调");
                    EventHelper.onEvent(MainActivity.this, Constants.EVENT_TYPE_END, eventParams);
                }
            }, 3000);
        }
    }
}
