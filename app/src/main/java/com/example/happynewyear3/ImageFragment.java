/*package com.example.happynewyear2;
//import android.os.Bundle;
////import android.app.Fragment;
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//public class ImageFragment extends Fragment {
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.image_fragment, container, false);
//        return view;
//    }
//}




import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.app.Fragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ImageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_fragment, container, false);
        return view;
    }
}

*/





package com.example.happynewyear3;




import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.Toast;


public class ImageFragment extends Fragment {
    private ImageView button1;
    private ImageView button2;
//    private String TAG_AUDIO = "AUDIO_ID1";
//    SharedPreferences sharedPreferences;
    private AudioPlayer mPlayer = new AudioPlayer();
    View view = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_fragment, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        sharedPreferences = getActivity().getSharedPreferences(TAG_AUDIO, Context.MODE_PRIVATE);
//        Toast.makeText(getActivity(), "" + sharedPreferences.getInt(TAG_AUDIO, -1), Toast.LENGTH_LONG).show();
//        if (sharedPreferences.getInt(TAG_AUDIO, -1) != -1){
////            mPlayer.mPlayer.setAudioSessionId(sharedPreferences.getInt(TAG_AUDIO, -1));
//        }


        button1 = (ImageView) getView().findViewById(R.id.imageView1);
        button2 = (ImageView) getView().findViewById(R.id.imageView2);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mPlayer.play(getActivity().getApplicationContext());




            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.pause();
            }
        });
    }

    @Override
    public void onDestroy(){

//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(TAG_AUDIO, mPlayer.mPlayer.getAudioSessionId());
//        Toast.makeText(getActivity(), "" + mPlayer.mPlayer.getAudioSessionId(), Toast.LENGTH_LONG).show();
//        editor.apply();
//        mPlayer.stop();
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}



class AudioPlayer{
    public static MediaPlayer mPlayer;
    public String play(Context context){
        if (mPlayer == null){
            mPlayer = MediaPlayer.create(context, R.raw.music);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stop();
                }
            });
            mPlayer.start();
            return "null";
        }
        else if (mPlayer.isPlaying()){
            stop();
            mPlayer = MediaPlayer.create(context, R.raw.music);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stop();
                }
            });
            mPlayer.start();
            return "isPlaying";

        }
        mPlayer.start();
        return "Nothing";

    }
    public void pause(){
        if (mPlayer != null && mPlayer.isPlaying()){
            mPlayer.pause();
        }
    }
    public void stop(){
        if (mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

}




