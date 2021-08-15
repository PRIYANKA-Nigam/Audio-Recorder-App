package com.example.audiorecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
TextView textView;Button button;ImageView imageView;
    MediaRecorder mediaRecorder; public static String filename="recorded.jpg";
    String file= Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+filename;@Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageView4); button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                ActivityOptionsCompat options=ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,imageView
                        , ViewCompat.getTransitionName(imageView)); startActivity(intent,options.toBundle()); }});
        textView=(TextView)findViewById(R.id.textView); mediaRecorder=new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);mediaRecorder.setOutputFile(file); }
        public void onclick(View view) throws IOException { if (view.getId()==R.id.imageView){ record();
        }else if (view.getId()==R.id.imageView2){ stopAudio();
        }else if (view.getId()==R.id.imageView3){ playAudio(); } }
        private void playAudio() throws IOException { MediaPlayer mediaPlayer=new MediaPlayer();
        mediaPlayer.setDataSource(file);mediaPlayer.prepare();mediaPlayer.start();
        textView.setText("Playing Recorded Audio"); }
        private void stopAudio() { mediaRecorder.stop();mediaRecorder.release();textView.setText("Recording Stopped");}
        private void record() throws IOException {
        mediaRecorder.prepare();
        mediaRecorder.start();
        textView.setText("Audio Recording ........."); }
}