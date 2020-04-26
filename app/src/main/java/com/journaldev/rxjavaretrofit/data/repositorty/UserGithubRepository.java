package com.journaldev.rxjavaretrofit.data.repositorty;

import com.journaldev.rxjavaretrofit.data.api.ApiRetrofit;
import com.journaldev.rxjavaretrofit.data.api.CryptocurrencyService;
import com.journaldev.rxjavaretrofit.data.model.Crypto;
import com.journaldev.rxjavaretrofit.domain.CallBackUseCase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserGithubRepository {


    private CryptocurrencyService cryptocurrencyService;
    private Observable<List<Crypto.Market>> btcObservable;
    private  Observable<List<Crypto.Market>> ethObservable;

    public UserGithubRepository(){
         cryptocurrencyService = ApiRetrofit.retrofit().create(CryptocurrencyService.class);
    }

    public void setInputGetOutPut(final String propertyOne,final String propertyTwo ,  CallBackUseCase callBack){
        btcObservable = cryptocurrencyService.getCoinData(propertyOne).map(result->Observable.fromIterable(result.ticker.markets)).flatMap(x->x).filter(y->{ y.coinName = propertyOne;return true; }).toList().toObservable();
        ethObservable = cryptocurrencyService.getCoinData(propertyTwo).map(result->Observable.fromIterable(result.ticker.markets)).flatMap(x->x).filter(y->{ y.coinName = propertyTwo;return true; }).toList().toObservable();
        Observable.merge(btcObservable,ethObservable).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(callBack::succsess, callBack::failure);
    }
}
