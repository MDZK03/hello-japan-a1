package edu.hanu.a1_2001040034;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public void stopPlaying(ArrayList<MediaPlayer> pause) {
        for (int i = 0; i < pause.size(); i++) {
            if(pause.get(i).isPlaying()) {
                pause.get(i).stop();
                try {
                    pause.get(i).prepare();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScrollView svHira = findViewById(R.id.sv1);
        ScrollView svKata = findViewById(R.id.sv2);

        TextView titleH = findViewById(R.id.titleHira);
        TextView titleK = findViewById(R.id.titleKata);

        int[] s = new int[] {
                R.raw.a,R.raw.i,R.raw.u,R.raw.e,R.raw.o,
                R.raw.ka,R.raw.ki,R.raw.ku,R.raw.ke,R.raw.ko,
                R.raw.sa,R.raw.shi,R.raw.su,R.raw.se,R.raw.so,
                R.raw.ta,R.raw.chi,R.raw.tsu,R.raw.te,R.raw.to,
                R.raw.na,R.raw.ni,R.raw.nu,R.raw.ne,R.raw.no,
                R.raw.ha,R.raw.hi,R.raw.fu,R.raw.he,R.raw.ho,
                R.raw.ma,R.raw.mi,R.raw.mu,R.raw.me,R.raw.mo,
                R.raw.ya,R.raw.yu,R.raw.yo,
                R.raw.ra,R.raw.ri,R.raw.ru,R.raw.re,R.raw.ro,
                R.raw.wa,R.raw.wo,R.raw.n};
        ArrayList<MediaPlayer> mp = new ArrayList<>();
        for(int i = 0; i < 46; i++) {
            mp.add(MediaPlayer.create(MainActivity.this,s[i]));
        }

        int[] imbH = new int[] {
                R.id.hA,R.id.hI,R.id.hU,R.id.hE,R.id.hO,
                R.id.hKa,R.id.hKi,R.id.hKu,R.id.hKe,R.id.hKo,
                R.id.hSa,R.id.hShi,R.id.hSu,R.id.hSe,R.id.hSo,
                R.id.hTa,R.id.hChi,R.id.hTsu,R.id.hTe,R.id.hTo,
                R.id.hNa,R.id.hNi,R.id.hNu,R.id.hNe,R.id.hNo,
                R.id.hHa,R.id.hHi,R.id.hFu,R.id.hHe,R.id.hHo,
                R.id.hMa,R.id.hMi,R.id.hMu,R.id.hMe,R.id.hMo,
                R.id.hYa,R.id.hYu,R.id.hYo,
                R.id.hRa,R.id.hRi,R.id.hRu,R.id.hRe,R.id.hRo,
                R.id.hWa,R.id.hWo,R.id.hN};
        ArrayList<ImageButton> imbHira = new ArrayList<>();
        for(int i = 0; i < 46; i++) {
            imbHira.add(findViewById(imbH[i]));
            int finalI = i;
            imbHira.get(i).setOnClickListener(v -> {
                stopPlaying(mp);
                mp.get(finalI).start();
            });
        }

        int[] imbK = new int[] {
                R.id.kA,R.id.kI,R.id.kU,R.id.kE,R.id.kO,
                R.id.kKa,R.id.kKi,R.id.kKu,R.id.kKe,R.id.kKo,
                R.id.kSa,R.id.kShi,R.id.kSu,R.id.kSe,R.id.kSo,
                R.id.kTa,R.id.kChi,R.id.kTsu,R.id.kTe,R.id.kTo,
                R.id.kNa,R.id.kNi,R.id.kNu,R.id.kNe,R.id.kNo,
                R.id.kHa,R.id.kHi,R.id.kFu,R.id.kHe,R.id.kHo,
                R.id.kMa,R.id.kMi,R.id.kMu,R.id.kMe,R.id.kMo,
                R.id.kYa,R.id.kYu,R.id.kYo,
                R.id.kRa,R.id.kRi,R.id.kRu,R.id.kRe,R.id.kRo,
                R.id.kWa,R.id.kWo,R.id.kN};
        ArrayList<ImageButton> imbKata = new ArrayList<>();
        for(int i = 0; i < 46; i++) {
            imbKata.add(findViewById(imbK[i]));
            int finalI = i;
            imbKata.get(i).setOnClickListener(v -> {
                stopPlaying(mp);
                mp.get(finalI).start();
            });
        }

        Button btnHira = findViewById(R.id.btnHira);
        Button btnKata = findViewById(R.id.btnKata);

        btnHira.setOnClickListener(v -> {
            if (svHira.getVisibility()== View.INVISIBLE && titleH.getVisibility() == View.INVISIBLE) {
                svKata.animate().alpha(0).setDuration(1000).
                        withEndAction(() -> svKata.setVisibility(View.INVISIBLE));
                titleK.animate().alpha(0).setDuration(1000).
                        withEndAction(() -> titleK.setVisibility(View.INVISIBLE));
                btnKata.animate().alpha(0.5f).setDuration(100);
                svHira.animate().translationXBy(-1500).setDuration(1000).
                        withEndAction(() -> {
                            svHira.animate().alpha(1).setDuration(1000);
                            svHira.setVisibility(View.VISIBLE);
                        });
                titleH.animate().translationXBy(-1500).setDuration(1000).
                        withEndAction(() -> {
                            titleH.animate().alpha(1).setDuration(1000);
                            titleH.setVisibility(View.VISIBLE);
                        });
                btnHira.animate().alpha(1).setDuration(100);
            } else {
                svHira.animate().rotationYBy(360).setDuration(1000);
                titleH.animate().rotationYBy(360).setDuration(1000);
                btnHira.animate().alpha(1);
            }
        });
        btnKata.setOnClickListener(v -> {
            if (svKata.getVisibility()== View.INVISIBLE && titleK.getVisibility() == View.INVISIBLE) {
                svHira.animate().translationXBy(1500).setDuration(1500).
                        withEndAction(() -> {
                            svHira.animate().alpha(0).setDuration(1500);
                            svHira.setVisibility(View.INVISIBLE);
                        });
                titleH.animate().translationXBy(1500).setDuration(1500).
                        withEndAction(() -> {
                            titleH.animate().alpha(0).setDuration(1500);
                            titleH.setVisibility(View.INVISIBLE);
                        });
                btnHira.animate().alpha(0.5f).setDuration(100);
                svKata.animate().alpha(1).setDuration(1000).
                        withEndAction(() -> svKata.setVisibility(View.VISIBLE));
                titleK.animate().alpha(1).setDuration(1000).
                        withEndAction(() -> titleK.setVisibility(View.VISIBLE));
                btnKata.animate().alpha(1).setDuration(100);
            } else {
                svKata.animate().alpha(0).setDuration(100).
                        withEndAction(() -> svKata.animate().alpha(1).setDuration(100));
                titleK.animate().alpha(0).setDuration(100).
                        withEndAction(() -> titleK.animate().alpha(1).setDuration(100));
                btnKata.animate().alpha(1);
            }
        });
    }
}