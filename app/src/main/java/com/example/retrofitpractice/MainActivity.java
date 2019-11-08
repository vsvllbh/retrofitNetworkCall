package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitpractice.POJO.mtest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    API_EndPoints api_endPoints;


    //use shared preference to store and retrive the data
    public static final String PREFS_GAME ="com.example.retrofitpractice.GamePlay";
    public static final String GAME_SCORE= "GameScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api_endPoints = APIClient.getClient().create(API_EndPoints.class);

        //Create a new user
        final mtest details = new mtest("morpheus", "leader");
        Call<mtest> mCreateUserCall = api_endPoints.createUser(details);
        mCreateUserCall.enqueue(new Callback<mtest>() {
            @Override
            public void onResponse(Call<mtest> call, Response<mtest> response) {
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
                mtest user1 = response.body();
                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
                saveLoginDetails(user1.name ,user1.job);

            }

            @Override
            public void onFailure(Call<mtest> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void saveLoginDetails(String name, String job) {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", name);
        editor.putString("Password", job);
        editor.commit();

        Log.d("myPreferences",""+getEmail());
    }

    private String getEmail() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Email", "");
    }

}