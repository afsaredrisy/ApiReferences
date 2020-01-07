package co.myapp.assignement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import co.myapp.assignement.Helper.ApiResponseListner;
import co.myapp.assignement.R;
import co.myapp.assignement.network.AttanceDataFetcher;
import co.myapp.assignement.viewModel.Attendance;
import co.myapp.assignement.viewModel.DataView;

public class MainActivity extends AppCompatActivity implements ApiResponseListner {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        fetchAttandance();
    }

    private void fetchAttandance(){
        AttanceDataFetcher fetcher = new AttanceDataFetcher(getApplication());
        fetcher.setResponseListner(this);
        fetcher.fetch();
    }

    private void setupData(Attendance[] attendances){
        Adapter adapter=new Adapter(this);
        adapter.setAttendance(attendances);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSuccess(DataView dataView) {
        setupData(dataView.getAttendance());
    }

    @Override
    public void onError(Throwable t) {
        Toast.makeText(this,"Something went wrong",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFail(int responseCode) {
        if(responseCode == 400){
            Toast.makeText(this,"Bad Request",Toast.LENGTH_LONG).show();
        }
    }
}
