package get_data;

import android.os.AsyncTask;
import android.util.Log;

import com.example.root.cinemacity.RegisterActivity;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import models.Cinema;

public class GetCinemasFromRest extends AsyncTask<String, Void, List<Cinema>> {
    @Override
    protected List<Cinema> doInBackground(String... urls) {

        List<Cinema> cinemasList = null;
        try {
            final String url = RegisterActivity.URL + "/rest/cinema/all";
            RestTemplate restTemplate = new RestTemplate(true);

            Cinema[] list = restTemplate.getForObject(url, Cinema[].class);
            cinemasList = Arrays.asList(list);

        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return cinemasList;
    }

    @Override
    protected void onPostExecute(List<Cinema> result) {

    }
}
