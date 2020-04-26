package com.journaldev.rxjavaretrofit.presentation.view;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.journaldev.rxjavaretrofit.R;
import com.journaldev.rxjavaretrofit.data.api.ApiRetrofit;
import com.journaldev.rxjavaretrofit.data.api.CryptocurrencyService;
import com.journaldev.rxjavaretrofit.data.model.Crypto;
import com.journaldev.rxjavaretrofit.presentation.view_model.UserGithub;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


//https://stackoverflow.com/questions/60220564/how-to-create-usecase-for-mvvm-clean-architecture-in-android
public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;
    private  RecyclerViewAdapter recyclerViewAdapter;
    private UserGithub  userGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        // Send to view viewmodel
        userGithub = new UserGithub();
        userGithub.init("btc", "eth");

        // Get from viewmodel
        userGithub.listData.observe(MainActivity.this, new Observer<List<Crypto.Market>>() {
            @Override
            public void onChanged(@Nullable List<Crypto.Market> markets) {
                recyclerViewAdapter.setData(markets);
            }
        });
     }
}
