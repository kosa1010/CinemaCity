package get_data;

import android.os.AsyncTask;
import android.util.Log;

import com.example.root.cinemacity.RegisterActivity;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import models.Movie;

public class GetMoviesFromRest extends AsyncTask<String, Void, List<Movie>> {
    @Override
    protected List<Movie> doInBackground(String... urls) {

        List<Movie> moviesList = null;
        try {
            final String url = RegisterActivity.URL + "/rest/movie/all";
            RestTemplate restTemplate = new RestTemplate(true);

            Movie[] list = restTemplate.getForObject(url, Movie[].class);
            moviesList = Arrays.asList(list);

        } catch (Exception e) {
            Log.e("MovieActivity", e.getMessage(), e);
        }
        return moviesList;
    }

    @Override
    protected void onPostExecute(List<Movie> result) {

    }
}
