package fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.root.cinemacity.R;

import junit.framework.Test;

/**
 * Created by root on 09.06.16.
 */
@SuppressLint("ValidFragment")
public class TestFragment extends Fragment {
    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int content;

    public TestFragment(int content) {
        this.content = content;
    }

    Spinner spinnerCinema;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(content,
                container, false);

    }
}
