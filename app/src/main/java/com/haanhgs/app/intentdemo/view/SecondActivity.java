package com.haanhgs.app.intentdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.haanhgs.app.intentdemo.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.haanhgs.app.intentdemo.view.MainActivity.SEND;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.tvSecond)
    TextView tvSecond;
    @BindView(R.id.etReply)
    EditText etReply;
    @BindView(R.id.bnReply)
    Button bnReply;
    public static final String REPLY = "reply";

    private void receiveIntent(){
        Intent intent = getIntent();
        tvSecond.setText(intent.getStringExtra(SEND));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        receiveIntent();
    }

    private void replyMessage(){
        Intent replyIntent = new Intent();
        if (!TextUtils.isEmpty(etReply.getText())){
            replyIntent.putExtra(REPLY, etReply.getText().toString());
            setResult(RESULT_OK, replyIntent);
            finish();
        }
    }

    @OnClick(R.id.bnReply)
    public void onViewClicked() {
        replyMessage();
    }
}
