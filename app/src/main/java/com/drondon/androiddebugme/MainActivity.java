package com.drondon.androiddebugme;

import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.drondon.androiddebugme.logger.Logger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity_";

    private Button btnVerbose, btnDebug, btnInfo, btnWarning, btnError, btnWTF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Debug.waitForDebugger();
        btnVerbose = findViewById(R.id.btnVerbose);
        btnVerbose.setOnClickListener(this);
        btnDebug = findViewById(R.id.btnDebug);
        btnDebug.setOnClickListener(this);
        btnInfo = findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(this);
        btnWarning = findViewById(R.id.btnWarning);
        btnWarning.setOnClickListener(this);
        btnError = findViewById(R.id.btnError);
        btnError.setOnClickListener(this);
        btnWTF = findViewById(R.id.btnWTF);
        btnWTF.setOnClickListener(this);
    }

    /**
     * You can use special code completions: logd,logm,logt etc.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnVerbose:
                Log.v(TAG, "onClick: VERBOSE");
                break;
            case R.id.btnDebug:
                Log.d(TAG, "onClick: DEBUG");
                //Logger.d(TAG, "onClick: DEBUG SET PROP");
                break;
            case R.id.btnInfo:
                Log.i(TAG, "onClick: INFO");
                break;
            case R.id.btnWarning:
                Log.w(TAG, "onClick: WARNING");
                break;
            case R.id.btnError:
                Log.e(TAG, "onClick: ERROR");
                break;
            case R.id.btnWTF:
                //What a Terrible Failure: Report a condition that should never happen.
                //https://stackoverflow.com/a/46678586/3124400
                Log.wtf(TAG, "onClick: What a Terrible Failure");
                break;
        }
    }
}
