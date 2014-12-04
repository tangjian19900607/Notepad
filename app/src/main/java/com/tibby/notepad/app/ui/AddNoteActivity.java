package com.tibby.notepad.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.tibby.notepad.app.R;
import com.tibby.notepad.app.domain.Notepad;

/**
 * Author:tibby tang
 * Created on 4/12/14.
 * Email:tangjian19900607@gmail.com
 * QQ:562980080
 */
public class AddNoteActivity extends Activity {
    private EditText mTitleEditText;
    private EditText mContentEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView(){
        this.mTitleEditText = (EditText) this.findViewById(R.id.note_title);
        this.mContentEditText = (EditText) this.findViewById(R.id.note_content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.note_save) {
            saveNote();
            return true;
        }else if (id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void saveNote() {
        String title = mTitleEditText.getText().toString();
        String content = mContentEditText.getText().toString();
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)){
            Toast.makeText(this,"please add a note",Toast.LENGTH_SHORT).show();
        }else {
            Notepad notepad = new Notepad(title,content);
            Intent intent = new Intent();
            intent.putExtra(MainActivity.NOTE,notepad);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
