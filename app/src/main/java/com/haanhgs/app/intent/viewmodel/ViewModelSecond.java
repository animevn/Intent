package com.haanhgs.app.intent.viewmodel;

import android.app.Application;
import com.haanhgs.app.intent.model.SecondModel;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ViewModelSecond extends AndroidViewModel {

    private final MutableLiveData<SecondModel> secondData = new MutableLiveData<>();

    public ViewModelSecond(@NonNull Application application) {
        super(application);
        secondData.setValue(new SecondModel());
    }

    public MutableLiveData<SecondModel> getSecondData() {
        return secondData;
    }

    public void setSecondData(String string){
        if (secondData.getValue() != null){
            SecondModel secondModel = secondData.getValue();
            secondModel.setMessage(string);
            secondData.setValue(secondModel);
        }
    }

}
