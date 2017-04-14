package id.ac.umn.onc.mydiary.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import id.ac.umn.onc.mydiary.R;
import id.ac.umn.onc.mydiary.model.Memo;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Memo> memos = new ArrayList<>();
    ArrayList<String> memosName = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
