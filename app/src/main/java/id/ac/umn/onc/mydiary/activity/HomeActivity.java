package id.ac.umn.onc.mydiary.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import id.ac.umn.onc.mydiary.R;
import id.ac.umn.onc.mydiary.model.Memo;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Memo> memos = new ArrayList<>();
    ArrayList<String> memosName = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
        ArrayList<String> strings = new ArrayList<>();
        ScrollView.LayoutParams params = new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ScrollView sc = new ScrollView(this);
        TableLayout tb = new TableLayout(this);
        if(strings.isEmpty()){
            TableRow tr = new TableRow(this);
            TextView tv = new TextView(this);
            tv.setText("No Data");
            tr.addView(tv);
            tb.addView(tr);
        }
        else{
            TableRow tr = new TableRow(this);
            TextView tv = new TextView(this);
            tv.setText("No Data2");
            tr.addView(tv);
            tb.addView(tr);
        }
        sc.addView(tb);
        int paddingPixel = 16;
        float density = getResources().getDisplayMetrics().density;
        int paddingDp = (int)(paddingPixel * density);
        sc.setPadding(paddingDp,paddingDp,paddingDp,paddingDp);
        this.addContentView(sc,params);
    }
}
