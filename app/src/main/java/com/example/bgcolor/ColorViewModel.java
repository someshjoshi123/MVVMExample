package com.example.bgcolor;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ColorViewModel extends ViewModel {
    MutableLiveData<Boolean> currentState = new MutableLiveData<>(false);

}
