package com.example.dell.changeicon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=(ImageView)findViewById(R.id.imageView);
        progressBar=(ProgressBar)findViewById(R.id.progress);



    }

    public void checkButtonClicked(View v){
        Toast.makeText(this,"THIS IS A CHECK BUTTON",Toast.LENGTH_SHORT).show();

    }
    public void loadButtonClicked(View v){
        Toast.makeText(this,"THIS IS A LOAD BUTTON",Toast.LENGTH_SHORT).show();
        new LoadIcon().execute(R.drawable.acadview);
    }



    class LoadIcon extends AsyncTask<Integer,Integer,Bitmap>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... integers) {
            Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.acadview);
            for(int i=0;i<10;i++){
                try{
                    Thread.sleep(1000);
                    publishProgress(i*10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }



            return bitmap;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            iv.setImageBitmap(bitmap);
        }
    }
}
