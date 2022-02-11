package com.example.colorpage;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.net.HttpCookie;

public class Testviewmodel extends ViewModel {
    public HttpCookie OurrentState;
    MutableLiveData<Boolean> currentState = new MutableLiveData<>(false);

}
