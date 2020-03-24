package com.haanhgs.app.intent.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.haanhgs.app.intent.R;
import com.haanhgs.app.intent.viewmodel.ViewModelFirst;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.haanhgs.app.intent.model.Constants.SEND;
import static com.haanhgs.app.intent.model.Constants.SEND_REQUEST;
import static com.haanhgs.app.intent.view.SecondActivity.REPLY;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvMain)
    TextView tvMain;
    @BindView(R.id.etMessage)
    EditText etMessage;
    @BindView(R.id.bnSend)
    Button bnSend;

    private ViewModelFirst viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewModel = new ViewModelProvider(this).get(ViewModelFirst.class);
        viewModel.getFirstData().observe(this, firstModel->tvMain.setText(firstModel.getMessage()));
    }

    private void sendMessage(){
        if (!TextUtils.isEmpty(etMessage.getText())){
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(SEND, etMessage.getText().toString());
            startActivityForResult(intent, SEND_REQUEST);
            viewModel.setFirstData("");
            etMessage.setText("");
        }
    }

    @OnClick(R.id.bnSend)
    public void onViewClicked() {
        sendMessage();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SEND_REQUEST && resultCode == RESULT_OK && data != null){
            viewModel.setFirstData(data.getStringExtra(REPLY));
        }
    }

}
