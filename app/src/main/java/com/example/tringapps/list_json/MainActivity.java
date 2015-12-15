package com.example.tringapps.list_json;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import java.lang.String;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contacts> arrayList=new ArrayList<Contacts>();
    private String name, email, address, gender, mob, home, office,id;
    private ContactAdapter myadapter;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new Myclass().execute();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        list=(ListView)findViewById(R.id.list);
    }

    public class Myclass extends AsyncTask<String, Void, Void> {
       private StringBuffer reader;
        @Override
        protected Void doInBackground(String... params) {
            try {
                URL url = new URL("http://api.androidhive.info/contacts/");
                HttpURLConnection httpurl = (HttpURLConnection) url.openConnection();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(httpurl.getInputStream()));
                reader = new StringBuffer();
                String input;
                while ((input = in.readLine()) != null) {
                    reader.append(input);
                }
                in.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            myadapter=new ContactAdapter(MainActivity.this,arrayList);
            list.setAdapter(myadapter);
            JSONObject obj = null;
            try {
                obj = new JSONObject(reader.toString());
                JSONArray array = obj.getJSONArray("contacts");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject json1 = array.getJSONObject(i);
                    id=json1.getString("id");
                    name = json1.getString("name");
                    email = json1.getString("email");
                    address = json1.getString("address");
                    gender = json1.getString("gender");
                    JSONObject json3 = json1.getJSONObject("phone");
                    mob = json3.getString("mobile");
                    home = json3.getString("home");
                    office = json3.getString("office");
                    Contacts contact=new Contacts();
                    contact.setId(id);
                    contact.setName(name);
                    contact.setEmail(email);
                    contact.setAddress(address);
                    contact.setGender(gender);
                    contact.setMobile(mob);
                    contact.setHome(home);
                    contact.setOffice(office);
                    arrayList.add(contact);
                }
                myadapter.notifyDataSetChanged();
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent=new Intent(MainActivity.this,Contact_details.class);
                        intent.putExtra("object",arrayList.get(position));
                        startActivity(intent);
                    }
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
