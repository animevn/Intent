package com.haanhgs.app.intentdemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.tvSecond)
    TextView tvSecond;
    @BindView(R.id.etReply)
    EditText etReply;
    @BindView(R.id.bnReply)
    Button bnReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bnReply)
    public void onViewClicked() {
    }
}
