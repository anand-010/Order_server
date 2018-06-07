package com.android.order_ser;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.algolia.search.saas.AlgoliaException;
import com.algolia.search.saas.Client;
import com.algolia.search.saas.CompletionHandler;
import com.algolia.search.saas.Index;
import com.algolia.search.saas.Query;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anand on 6/1/2018.
 */

public class serch extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Index index;
    List<String> input;
    Query query;
    JSONArray jsonArray;
    JSONObject jsonObject;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serch);
        editText = (EditText)findViewById(R.id.edi);
        textView = (TextView)findViewById(R.id.textView);
        final Client client = new Client("IX9BAMWVUR", "cf3070c43f7e35c8d10ee8928cf0da16");
        index = client.getIndex("getstarted_actors");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        query = new Query(editText.getText().toString())
            .setAttributesToRetrieve("name", "rating")
            .setHitsPerPage(50);
        index.searchAsync(query, new CompletionHandler() {
            @Override
            public void requestCompleted(JSONObject content, AlgoliaException error){

jsonObject = content;
                try {
                    jsonArray = content.getJSONArray("hits");

                    input = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    Object jsonObject2 = jsonObject1.get("name");
                    input.add(jsonObject2.toString());
                    textView.setText(jsonObject2.toString());
                    }// define an adapter
                    mAdapter = new MyAdapter(input);
                    DefaultItemAnimator defaultItemAnimator =new DefaultItemAnimator();
                    defaultItemAnimator.setAddDuration(1000);
                    defaultItemAnimator.setRemoveDuration(2000);
                    recyclerView.setItemAnimator(defaultItemAnimator);
                    recyclerView.setAdapter(mAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
});

    }
}