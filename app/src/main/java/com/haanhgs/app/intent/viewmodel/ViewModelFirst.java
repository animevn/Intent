package com.haanhgs.app.intent.viewmodel;

import android.app.Application;
import com.haanhgs.app.intent.model.FirstModel;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ViewModelFirst extends AndroidViewModel {

    private final MutableLiveData<FirstModel> firstData = new MutableLiveData<>();

    public ViewModelFirst(@NonNull Application application) {
        super(application);
        firstData.setValue(new FirstModel());
    }

    public MutableLiveData<FirstModel> getFirstData() {
        return firstData;
    }

    public void setFirstData(String string){
        if (firstData.getValue() != null){
            FirstModel firstModel = firstData.getValue();
            firstModel.setMessage(string);
            firstData.setValue(firstModel);
        }

    }
}
