package id.ac.umn.onc.mydiary.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.ac.umn.onc.mydiary.R;
import id.ac.umn.onc.mydiary.model.Utilities;

public class HomeActivity extends AppCompatActivity {
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        //buat menu diatas kanan, tapi buat dulu menunya
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.transition.fadein, R.transition.fadeout);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); ini tombol back
        //setContentView(R.layout.activity_home);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pretium rhoncus nibh, eget bibendum leo auctor id. Aenean eu tincidunt sem. Mauris elementum luctus turpis non imperdiet. Phasellus enim nulla, finibus et libero ullamcorper, maximus vestibulum justo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent fermentum, tellus ac malesuada ullamcorper, neque nisl condimentum dolor, ut tincidunt elit mi ac ligula. Donec blandit felis mauris, nec ornare nulla varius ac. Proin mattis bibendum cursus. Integer et tellus nec tellus ultricies tincidunt vel ac risus. Morbi rhoncus iaculis volutpat. ");
        strings.add("Nam urna orci, varius id porta id, efficitur eget dolor. Morbi vel metus interdum, congue mi id, porttitor lacus. Aliquam tincidunt porta condimentum. Ut lorem leo, semper a blandit non, efficitur quis arcu. Suspendisse ut nisl nec massa gravida condimentum. Nullam purus enim, aliquet imperdiet ullamcorper eu, euismod auctor ligula. Phasellus blandit, lacus et gravida posuere, ligula quam semper nunc, a mollis quam enim vitae eros. Duis imperdiet consequat ipsum, sed feugiat ante vehicula sit amet. Morbi tincidunt ante accumsan sagittis molestie. In accumsan vehicula dolor, nec pharetra est placerat et. Praesent vitae eleifend sem. Sed elementum nec justo quis ultricies.");
        strings.add("Fusce nec fringilla ante. Phasellus dignissim vel lorem ac venenatis. Proin cursus egestas elit, sed sagittis orci rhoncus sed. Donec est quam, semper sed egestas nec, fermentum nec neque. Phasellus ultrices tellus mi. Morbi convallis cursus lectus quis facilisis. Nullam dictum at leo non mollis. Nulla dictum ut urna ut posuere. Nulla volutpat urna vitae risus vulputate sollicitudin. Morbi non interdum erat, in tempus magna. Sed vel nunc eget libero dapibus vestibulum. Pellentesque venenatis libero augue, in accumsan ipsum tincidunt non. Fusce dignissim ac erat vitae eleifend. Cras vitae augue eu mauris sollicitudin volutpat. ");
        strings.add("Fusce nec fringilla ante. Phasellus dignissim vel lorem ac venenatis. Proin cursus egestas elit, sed sagittis orci rhoncus sed. Donec est quam, semper sed egestas nec, fermentum nec neque. Phasellus ultrices tellus mi. Morbi convallis cursus lectus quis facilisis. Nullam dictum at leo non mollis. Nulla dictum ut urna ut posuere. Nulla volutpat urna vitae risus vulputate sollicitudin. Morbi non interdum erat, in tempus magna. Sed vel nunc eget libero dapibus vestibulum. Pellentesque venenatis libero augue, in accumsan ipsum tincidunt non. Fusce dignissim ac erat vitae eleifend. Cras vitae augue eu mauris sollicitudin volutpat. ");
        strings.add("Fusce nec fringilla ante. Phasellus dignissim vel lorem ac venenatis. Proin cursus egestas elit, sed sagittis orci rhoncus sed. Donec est quam, semper sed egestas nec, fermentum nec neque. Phasellus ultrices tellus mi. Morbi convallis cursus lectus quis facilisis. Nullam dictum at leo non mollis. Nulla dictum ut urna ut posuere. Nulla volutpat urna vitae risus vulputate sollicitudin. Morbi non interdum erat, in tempus magna. Sed vel nunc eget libero dapibus vestibulum. Pellentesque venenatis libero augue, in accumsan ipsum tincidunt non. Fusce dignissim ac erat vitae eleifend. Cras vitae augue eu mauris sollicitudin volutpat. ");
        strings.add("Fusce nec fringilla ante. Phasellus dignissim vel lorem ac venenatis. Proin cursus egestas elit, sed sagittis orci rhoncus sed. Donec est quam, semper sed egestas nec, fermentum nec neque. Phasellus ultrices tellus mi. Morbi convallis cursus lectus quis facilisis. Nullam dictum at leo non mollis. Nulla dictum ut urna ut posuere. Nulla volutpat urna vitae risus vulputate sollicitudin. Morbi non interdum erat, in tempus magna. Sed vel nunc eget libero dapibus vestibulum. Pellentesque venenatis libero augue, in accumsan ipsum tincidunt non. Fusce dignissim ac erat vitae eleifend. Cras vitae augue eu mauris sollicitudin volutpat. ");
        strings.add("Fusce nec fringilla ante. Phasellus dignissim vel lorem ac venenatis. Proin cursus egestas elit, sed sagittis orci rhoncus sed. Donec est quam, semper sed egestas nec, fermentum nec neque. Phasellus ultrices tellus mi. Morbi convallis cursus lectus quis facilisis. Nullam dictum at leo non mollis. Nulla dictum ut urna ut posuere. Nulla volutpat urna vitae risus vulputate sollicitudin. Morbi non interdum erat, in tempus magna. Sed vel nunc eget libero dapibus vestibulum. Pellentesque venenatis libero augue, in accumsan ipsum tincidunt non. Fusce dignissim ac erat vitae eleifend. Cras vitae augue eu mauris sollicitudin volutpat. ");
        strings.add("Fusce nec fringilla ante. Phasellus dignissim vel lorem ac venenatis. Proin cursus egestas elit, sed sagittis orci rhoncus sed. Donec est quam, semper sed egestas nec, fermentum nec neque. Phasellus ultrices tellus mi. Morbi convallis cursus lectus quis facilisis. Nullam dictum at leo non mollis. Nulla dictum ut urna ut posuere. Nulla volutpat urna vitae risus vulputate sollicitudin. Morbi non interdum erat, in tempus magna. Sed vel nunc eget libero dapibus vestibulum. Pellentesque venenatis libero augue, in accumsan ipsum tincidunt non. Fusce dignissim ac erat vitae eleifend. Cras vitae augue eu mauris sollicitudin volutpat. ");
        strings.add("Fusce nec fringilla ante. Phasellus dignissim vel lorem ac venenatis. Proin cursus egestas elit, sed sagittis orci rhoncus sed. Donec est quam, semper sed egestas nec, fermentum nec neque. Phasellus ultrices tellus mi. Morbi convallis cursus lectus quis facilisis. Nullam dictum at leo non mollis. Nulla dictum ut urna ut posuere. Nulla volutpat urna vitae risus vulputate sollicitudin. Morbi non interdum erat, in tempus magna. Sed vel nunc eget libero dapibus vestibulum. Pellentesque venenatis libero augue, in accumsan ipsum tincidunt non. Fusce dignissim ac erat vitae eleifend. Cras vitae augue eu mauris sollicitudin volutpat. ");
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
            boolean even = true;
            for(final String x: strings){
                TableRow tr = new TableRow(this);
                TextView tv = new TextView(this);
                TextView tvE = new TextView(this);
                final Context context = this;
                TableRow.LayoutParams param = new TableRow.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    1
                );
                int margin = Utilities.pxToDp(this,5);
                param.setMargins(margin,margin,margin,margin);
                tv.setLayoutParams(param);
                tvE.setLayoutParams(param);
                String x2 = "";
                if(x.length()>30){
                    x2 = x.substring(0,30)+"...";
                }
                tv.setText(x2);
                tv.setBackgroundColor(Color.argb(100,255,0,0));
                tv.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                int paddingDp = Utilities.pxToDp(this,5);
                tv.setPadding(paddingDp,paddingDp,paddingDp,paddingDp);
                tv.setGravity(Gravity.LEFT);
                if(even){
                    even=false;
                    tr.addView(tv);
                    tr.addView(tvE);
                }
                else {
                    even=true;
                    tr.addView(tvE);
                    tr.addView(tv);
                }
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, x, Toast.LENGTH_SHORT).show();
                    }
                });
                tv.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Delete");
                        builder.setMessage("Are you sure ? you can not undo this action")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(context, "belom dibikin hehe", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        return true;
                    }
                });
                tb.addView(tr);
            }
        }




        sc.addView(tb);
        int paddingDp = Utilities.pxToDp(this,16);
        sc.setPadding(paddingDp,paddingDp,paddingDp,paddingDp);
        this.addContentView(sc,params);
    }
}
