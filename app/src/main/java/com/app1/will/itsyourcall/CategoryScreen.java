package com.app1.will.itsyourcall;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class CategoryScreen extends ActionBarActivity {

    private String[] categories;
    private Spinner CategoryDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);
        setupCategories();

        beginButton();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     */
    private void setupCategories() {
        String values[] = {"Politics", "Sports", "Food", "Movies/Pop Culture", "Random"};
        this.categories = values;
        Spinner s = (Spinner) findViewById(R.id.CategoryDropdown);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        s.setAdapter(adapter);

    }

    private void beginButton() {
        Button beginGame = (Button) findViewById(R.id.beginGame);
        beginGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cat2question = new Intent(CategoryScreen.this, QuestionScreen.class);
                String categoryC = spinnerSelectedItem().toString();

                cat2question.putExtra("category", categoryC);

                startActivity(cat2question);

            }
        });
    }

    /**
     * Working on the bug fix here
     * @return
     */
    private Object spinnerSelectedItem() {
        CategoryDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public Object onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                return item;
            }

            @Override
            public Object onNothingSelected(AdapterView<?> parent) {
                return null;
            }
        });

    }
}
