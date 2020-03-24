package com.haanhgs.app.intent.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.haanhgs.app.intent.R;
import com.haanhgs.app.intent.viewmodel.ViewModelSecond;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.haanhgs.app.intent.model.Constants.SEND;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.tvSecond)
    TextView tvSecond;
    @BindView(R.id.etReply)
    EditText etReply;
    @BindView(R.id.bnReply)
    Button bnReply;
    public static final String REPLY = "reply";

    private ViewModelSecond viewModel;

    private void receiveIntent(){
        Intent intent = getIntent();
        tvSecond.setText(intent.getStringExtra(SEND));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        viewModel = new ViewModelProvider(this).get(ViewModelSecond.class);
        viewModel.getSecondData().observe(this, secondModel ->
                tvSecond.setText(secondModel.getMessage()));
        Intent intent = getIntent();
        viewModel.setSecondData(intent.getStringExtra(SEND));
    }

    private void replyMessage(){
        Intent replyIntent = new Intent();
        if (!TextUtils.isEmpty(etReply.getText())){
            replyIntent.putExtra(REPLY, etReply.getText().toString());
            setResult(RESULT_OK, replyIntent);
            viewModel.setSecondData("");
            etReply.setText("");
            finish();
        }
    }

    @OnClick(R.id.bnReply)
    public void onViewClicked() {
        replyMessage();
    }
}
