package com.elouazzani.myapplicationtest;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.elouazzani.myapplicationtest.model.Repository;
import com.elouazzani.myapplicationtest.model.RepositoryAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TrendingFragment extends Fragment {
    private RepositoryAdapter repositoryAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private List<Repository> repList;

    private int page=1;
    private int firstVisibleItem;
    private int totalItemCount;
    private int visibleItemCount;
    private int previousTotal;

    private boolean load=true;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_trending, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Trending Repos");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        layoutManager=new LinearLayoutManager(getContext());
        repList =new ArrayList<>();
        recyclerView=view.findViewById(R.id.trendingRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        repositoryAdapter=new RepositoryAdapter(getContext(),repList);
        recyclerView.setAdapter(repositoryAdapter);

        loadData();
        pagination();

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    // load data from api rest request
    private void loadData() {

        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        String url="https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc&page="
                +page;
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // JSONArray Parsing Method
                            JSONArray jsonArray=response.getJSONArray("items");
                            for (int i=0;i<jsonArray.length();i++) {
                                // JSONObject Parsing Methods
                                JSONObject repository=jsonArray.getJSONObject(i);
                                String repName=repository.getString("name");
                                String repDescription=repository.getString("description");
                                JSONObject owner= repository.getJSONObject("owner");
                                String username=owner.getString("login");
                                String avatar_url=owner.getString("avatar_url");
                                repList.add(new Repository(repName, repDescription
                                        ,5, username,avatar_url));
                            }
                            repositoryAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        requestQueue.add(request);

    }

    private void pagination() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem=layoutManager.findFirstVisibleItemPosition();
                totalItemCount=layoutManager.getChildCount();
                visibleItemCount=layoutManager.getItemCount();

                if (load) {
                    if(totalItemCount>previousTotal) {
                        previousTotal=totalItemCount;
                        page++;
                        load=false;
                    }
                }

                if(!load && (visibleItemCount+firstVisibleItem)>=totalItemCount) {
                    getNext();
                    load=true;

                    Log.v("tag","Page Number:"+page);
                }
            }
        });
    }

    // load data from next page
    private void getNext() {
        loadData();
    }


}