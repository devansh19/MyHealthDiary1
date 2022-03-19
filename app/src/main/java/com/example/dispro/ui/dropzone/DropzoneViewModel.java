package com.example.dispro.ui.dropzone;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DropzoneViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public DropzoneViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}