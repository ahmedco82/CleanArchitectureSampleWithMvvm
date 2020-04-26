package com.journaldev.rxjavaretrofit.presentation.view;


import android.arch.lifecycle.MutableLiveData;

import com.journaldev.rxjavaretrofit.data.model.Crypto;

import java.util.List;

public interface CallBackView {
    void LoadData(List<Crypto.Market> marketList);
    void NotLoad(String error);
}
