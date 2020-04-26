package com.journaldev.rxjavaretrofit.domain;

import android.arch.lifecycle.MutableLiveData;

import com.journaldev.rxjavaretrofit.data.model.Crypto;

import java.util.List;

public interface CallBackUseCase {
   void succsess(List<Crypto.Market>marketList);
   void failure(Throwable t);
}
