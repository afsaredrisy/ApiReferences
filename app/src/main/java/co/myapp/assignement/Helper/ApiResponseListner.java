package co.myapp.assignement.Helper;

import co.myapp.assignement.viewModel.DataView;

public interface ApiResponseListner {
    public void onSuccess(DataView dataView);
    public void onFail(int responseCode);
    public void onError(Throwable t);
}
