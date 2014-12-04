package com.tibby.notepad.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import com.tibby.notepad.app.R;
import com.tibby.notepad.app.adapter.NotepadAdapter;
import com.tibby.notepad.app.domain.Notepad;

import java.util.ArrayList;

/**
 * Author:tibby tang
 * Created on 4/12/14.
 * Email:tangjian19900607@gmail.com
 * QQ:562980080
 */
public class MainActivity extends Activity {

    public static final int REQUEST_NOTE_CODE = 1;
    public static final String NOTE = "com.tibby.notepad.app.NOTE";
    private ListView mListView;
    private TextView mEmptyTextview;

    private NotepadAdapter mNotepadAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setListener();
    }

    private void initView() {
        this.mListView = (ListView) this.findViewById(R.id.list_view);
        this.mEmptyTextview = (TextView) this.findViewById(R.id.empty_view);
    }

    private void setListener() {

    }

    private void initData(){
        mNotepadAdapter = new NotepadAdapter(new ArrayList<Notepad>(),this);
        this.mListView.setEmptyView(mEmptyTextview);
        this.mListView.setAdapter(mNotepadAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_note) {
            Intent intent = new Intent(this,AddNoteActivity.class);
            startActivityForResult(intent,REQUEST_NOTE_CODE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == REQUEST_NOTE_CODE) && (resultCode == RESULT_OK)){
            if(null != data){
                Notepad notepad = (Notepad) data.getSerializableExtra(NOTE);
                if (notepad != null){
                    mNotepadAdapter.addData(notepad);
                }
            }
        }
    }
}
