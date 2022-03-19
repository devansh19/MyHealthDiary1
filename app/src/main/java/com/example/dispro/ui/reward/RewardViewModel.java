package com.example.dispro.ui.reward;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RewardViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public RewardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}