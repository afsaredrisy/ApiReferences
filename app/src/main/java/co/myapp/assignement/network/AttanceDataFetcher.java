package co.myapp.assignement.network;

import android.content.Context;
import android.util.Log;

import co.myapp.assignement.Helper.ApiResponseListner;
import co.myapp.assignement.viewModel.DataView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AttanceDataFetcher {
    public static final String TAG = "AttanceDataFetcher";
    APIInterface apiInterface;
    private ApiResponseListner responseListner;

    private Context context;
    private Retrofit retrofitClient;

    public AttanceDataFetcher(Context context){
        this.context = context;
    }

    public ApiResponseListner getResponseListner() {
        return responseListner;
    }

    public void setResponseListner(ApiResponseListner responseListner) {
        this.responseListner = responseListner;
    }

    public void fetch(){
        getAttandanceList();
    }


    private void getAttandanceList(){
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<DataView> call = apiInterface.doGetListAttance();
        call.enqueue(new Callback<DataView>() {
            @Override
            public void onResponse(Call<DataView> call, Response<DataView> response) {
                Log.d(TAG,"OnSuccess"+response.toString());
                int code = response.code();
                if(code!=400){
                    if(responseListner != null){
                        responseListner.onSuccess(response.body());
                    }
                }
                else{
                    if(responseListner != null){
                        responseListner.onFail(code);
                    }
                }

            }

            @Override
            public void onFailure(Call<DataView> call, Throwable t) {
                Log.d(TAG,"Fail "+t.getLocalizedMessage());
                if(responseListner != null){
                    responseListner.onError(t);
                }
                call.cancel();
            }
        });
    }



}
