package tech.sidespell.prelimexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import java.lang.Override;
import java.lang.Runnable;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    TextView mTvTime;
    ToggleButton mBtnSwitch;
    RadioButton mBtnInc;
    RadioButton mBtnDec;
    RadioGroup mRdRadioGroup;
    SeekBar mSkSeekBar;
    TextView mTvSeekBar

    private long timeRemaining = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTvTime = (TextView) findViewById(R.id.textView);
        mBtnSwitch = (ToggleButton) findViewById(R.id.toggleButton);
        mBtnInc = (RadioButton) findViewById(R.id.inc);
        mBtnDec = (RadioButton) findViewById(R.id.dec);
        mRdRadioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        mSkSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mTvSeekBar = (TextView) findViewById(R.id.textView2);

        mRdRadioGroup.setOnClickListener(this);
        mBtnSwitch.setOnCheckedChangeListener(this);
        mSkSeekBar.setOnSeekBarChangeListener(this);

        mTvSeekBar.setText(mSkSeekBar.getProgress() + "");
        final Handler handler = new Handler();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                if(mBtnInc.isSelected()){
                    timeRemaining+=1;
                    mTvTime.setText(timeRemaining + "");
                }
                if else(mBtnDec.isSelected()){
                    timeRemaining-=1;
                    mTvTime.setText(timeRemaining + "");
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
