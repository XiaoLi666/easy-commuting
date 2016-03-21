package sg.edu.ntu.cz2006.seproject;

import android.util.Log;

import com.google.android.gms.common.api.Api;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func4;
import rx.schedulers.Schedulers;

public class MainPresenter extends MvpBasePresenter<MainView> {

    // get singleton objects
    private Observable<String> mApiFetchingTask;

    private void cancelSubscription() {
        if (mApiFetchingTask != null) {
            mApiFetchingTask.unsubscribeOn(Schedulers.io());
        }
    }

    public void fetchUVIndexData(String origin, String destination) {
        if (isViewAttached()) {
            getView().showLoading();
        }
        Log.d("TAG", origin);
        Log.d("TAG", destination);

        mApiFetchingTask = ApiRequestHelper.getInstance().getApiData(origin, destination);

        mApiFetchingTask.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("MAINPRESENTER", e.toString());
            }

            @Override
            public void onNext(String o) {
                Log.d("MAINPRESENTER", o);
                if (isViewAttached()) {
                    getView().showData(o);
                }
            }
        });
    }

    // called when Activity is destroyed, will cancel all tasks running
    public void detachView(boolean retainPresenterInstance){
        super.detachView(retainPresenterInstance);
        if (!retainPresenterInstance){
            cancelSubscription();
        }
    }
}
