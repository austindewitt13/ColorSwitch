package edu.cnm.deepdive.colorswitch;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private int seekR, seekG, seekB;
    SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    ImageView mScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScreen = (ImageView) findViewById(R.id.imageView);
        redSeekBar = (SeekBar) findViewById(R.id.mySeekingBar_R);
        greenSeekBar = (SeekBar) findViewById(R.id.mySeekingBar_G);
        blueSeekBar = (SeekBar) findViewById(R.id.mySeekingBar_B);
        updateBackground();
        redSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        greenSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blueSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener
            = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            updateBackground();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    private void updateBackground() {
        seekR = redSeekBar.getProgress();
        seekG = greenSeekBar.getProgress();
        seekB = blueSeekBar.getProgress();
        mScreen.setBackgroundColor(
                0xff000000
                        + seekR * 0x10000
                        + seekG * 0x100
                        + seekB
        );

    }
}
