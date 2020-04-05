package com.example.mob_dev3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ShowDbActivity extends AppCompatActivity
{
    private DBhelper dbHelper;
    private TextView getAllTextView;
    private TextView emptyDBTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_db);
        dbHelper = new DBhelper(this);

        getAllTextView = this.findViewById(R.id.allRows);
        emptyDBTextView = this.findViewById(R.id.emptyDB);
        getAllRows();
    }

    private void getAllRows() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_RESULTS, null, null, null, null, null, null);

        String allRows = "";

        if (cursor.moveToFirst()) {
            emptyDBTextView.setText("Номер спроби та відповідь");
            int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
            int phraseIndex = cursor.getColumnIndex(DBhelper.KEY_ANSWER);

            do {
                allRows += String.format("%-3d %-20s\n", cursor.getInt(idIndex), cursor.getString(phraseIndex));
//                System.out.println(allRows);

            } while (cursor.moveToNext() && !cursor.isLast());
            getAllTextView.setText(allRows);
        } else {
            emptyDBTextView.setText("0 row exists");
        }
        cursor.close();

        dbHelper.close();
    }
}
