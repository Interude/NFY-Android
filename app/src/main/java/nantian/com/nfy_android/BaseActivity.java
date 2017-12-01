package nantian.com.nfy_android;

import android.os.Bundle;

import net.tsz.afinal.FinalActivity;


/**
 *基础Activity
 * **/

public class BaseActivity extends FinalActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
