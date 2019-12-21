package com.haanhgs.app.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvMain)
    TextView tvMain;
    @BindView(R.id.etMessage)
    EditText etMessage;
    @BindView(R.id.bnSend)
    Button bnSend;

    public static final int SEND_REQUEST = 555;
    public static final String SEND = "send";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void sendMessage(){

        if (!TextUtils.isEmpty(etMessage.getText())){
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(SEND, etMessage.getText().toString());
            startActivityForResult(intent, SEND_REQUEST);

            tvMain.setText("");
            etMessage.setText("");
        }
    }

    @OnClick(R.id.bnSend)
    public void onViewClicked() {
        sendMessage();
    }
}
