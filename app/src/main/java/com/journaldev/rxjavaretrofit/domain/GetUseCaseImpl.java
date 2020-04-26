package com.journaldev.rxjavaretrofit.domain;


import com.journaldev.rxjavaretrofit.data.repositorty.UserGithubRepository;
import com.journaldev.rxjavaretrofit.data.model.Crypto;
import com.journaldev.rxjavaretrofit.presentation.view.CallBackView;

import java.util.List;


public class GetUseCaseImpl {

   private UserGithubRepository userGithubRepository;

   
    public GetUseCaseImpl(){
        userGithubRepository = new UserGithubRepository();
    }

    public void setItems(String item1, String item2, CallBackView callBackView) {
        userGithubRepository.setInputGetOutPut(item1, item2, new CallBackUseCase() {
            @Override
            public void succsess(List<Crypto.Market> marketList) {
                callBackView.LoadData(marketList);
            }

            @Override
            public void failure(Throwable t) {
                callBackView.NotLoad("error");
            }
        });
    }
}
