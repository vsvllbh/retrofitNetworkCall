package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitpractice.POJO.mtest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    API_EndPoints api_endPoints;

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

            }

            @Override
            public void onFailure(Call<mtest> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_LONG).show();
            }
        });
    }
}