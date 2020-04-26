package com.journaldev.rxjavaretrofit.presentation.view_model;

import android.arch.lifecycle.MutableLiveData;

import com.journaldev.rxjavaretrofit.data.model.Crypto;
import com.journaldev.rxjavaretrofit.domain.GetUseCaseImpl;
import com.journaldev.rxjavaretrofit.presentation.view.CallBackView;

import java.util.List;

public class UserGithub implements CallBackView{


    public MutableLiveData<List<Crypto.Market>>listData = new MutableLiveData<>();
    public MutableLiveData<String> failureRequest = new MutableLiveData<>();

    private GetUseCaseImpl getUseCase;

    public UserGithub(){
        getUseCase =new GetUseCaseImpl();
     }

     // Send request to UseCase ;
    public void init(String item1 , String item2){
      getUseCase.setItems(item1,item2 ,this);
    }

    @Override
    public void LoadData(List<Crypto.Market> marketList) {
        listData.setValue(marketList);
    }

    @Override
    public void NotLoad(String error) {
        failureRequest.setValue(error);
    }
}
