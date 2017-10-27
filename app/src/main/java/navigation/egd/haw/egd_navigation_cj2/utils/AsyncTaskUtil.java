package navigation.egd.haw.egd_navigation_cj2.utils;

import android.os.AsyncTask;
import android.util.Log;

import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListener;
import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListenerOnFinish;

/**
 * @author
 * Created by prann on 10/25/2017.
 */

public class AsyncTaskUtil extends AsyncTask<Object, Void, Object> {
    public IAsyncTaskListener asyncTaskListener;
    public IAsyncTaskListenerOnFinish asyncTaskListenerOnFinish;
    public AsyncTaskUtil() {
        super();
        asyncTaskListener = null;
        asyncTaskListenerOnFinish = null;
    }

    @Override
    protected Object doInBackground(Object... objects) {
        final String TAG = "Async background process";
        try {
            if(asyncTaskListener != null) {
                return asyncTaskListener.asyncTaskCallback(objects);
            }
            return null;
        } catch(Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    public void setAsyncTaskListener(IAsyncTaskListener asyncTaskListener) {
        this.asyncTaskListener = asyncTaskListener;
    }

    public void setAsyncTaskListenerOnFinish(IAsyncTaskListenerOnFinish asyncTaskListenerOnFinish) {
        this.asyncTaskListenerOnFinish = asyncTaskListenerOnFinish;
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        final String TAG = "Async background process";
        try {
            if(asyncTaskListenerOnFinish != null) {
                asyncTaskListenerOnFinish.onProcessFinish(result);
            }
        } catch(Exception e) {
            Log.e(TAG, e.toString());
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }
}
