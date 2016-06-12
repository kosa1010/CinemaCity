//package com.example.root.cinemacity;
//
//import android.support.design.widget.TabLayout;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//
//import models.Cinema;
//import get_data.*;
//
//public class UserActivity extends AppCompatActivity {
//
//    /**
//     * The {@link android.support.v4.view.PagerAdapter} that will provide
//     * fragments for each of the sections. We use a
//     * {@link FragmentPagerAdapter} derivative, which will keep every
//     * loaded fragment in memory. If this becomes too memory intensive, it
//     * may be best to switch to a
//     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
//     */
//    private SectionsPagerAdapter mSectionsPagerAdapter;
//
//    /**
//     * The {@link ViewPager} that will host the section contents.
//     */
//    private ViewPager mViewPager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user);
//        Button btnLoad = (Button) findViewById(R.id.btnLoad);
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        // Create the adapter that will return a fragment for each of the three
//        // primary sections of the activity.
//        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
//
//        // Set up the ViewPager with the sections adapter.
//        mViewPager = (ViewPager) findViewById(R.id.container);
//        mViewPager.setAdapter(mSectionsPagerAdapter);
//
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(mViewPager);
//
//        //proby chyly
//
//        Spinner spinCinema = (Spinner) findViewById(R.id.spinnerCinema);
//        final Spinner spinHall = (Spinner) findViewById(R.id.spinHall);
//
//        GetCinemasFromRest cinemasFromRest = new GetCinemasFromRest();
//        try {
//            List<Cinema> cinemasList = cinemasFromRest.execute(RegisterActivity.URL + "/rest/movie/all").get();
//            String[] arrayCinemasSpin = new String[cinemasList.size() + 1];
//            StringBuilder cinemaItem = new StringBuilder();
//            int i = 0;
////            for (Cinema c : cinemasList) {
////                cinemaItem.append(c.getName()).append(" ").append(c.getCity()).append(" ").append(c.getStreet());
////                arrayCinemasSpin[i] = String.valueOf(cinemaItem);
////                i+=1;
////            }
//            arrayCinemasSpin[0] = "1";
//            arrayCinemasSpin[1] = "2";
//            arrayCinemasSpin[2] = "3";
//
//
//            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                    android.R.layout.simple_spinner_item, arrayCinemasSpin);
//            btnLoad.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    spinHall.setAdapter(adapter);
//                }
//            });
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            Toast.makeText(this, "zepsuło się", Toast.LENGTH_LONG).show();
//        }
//
//
//        //                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
////                        android.R.layout.simple_spinner_item , arrayCinemasSpin);
////                spinCinema.setAdapter(adapter);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_user, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    /**
//     * A placeholder fragment containing a simple view.
//     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_user, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//
////            loadCinemasToView(rootView);
//
//            FragmentManager fragmentManager = getFragmentManager();
//            fragmentManager.beginTransaction()
//                    .replace(R.layout.fragment_user, PlaceholderFragment.newInstance(position + 1))
//                    .commit();
//            return rootView;}
//    }
//
//    private static void loadCinemasToView(View v) {
//
//        Spinner spinCinema = (Spinner) v.findViewById(R.id.spinnerCinema);
//        Spinner spinHall = (Spinner) v.findViewById(R.id.spinHall);
//
//        GetCinemasFromRest cinemasFromRest = new GetCinemasFromRest();
//        try {
//            List<Cinema> cinemasList = cinemasFromRest.execute(RegisterActivity.URL + "/rest/movie/all").get();
//            String[] arrayCinemasSpin = new String[cinemasList.size() + 1];
//            StringBuilder cinemaItem = new StringBuilder();
//            int i = 0;
//            for (Cinema c : cinemasList) {
//                cinemaItem.append(c.getName()).append(" ").append(c.getCity()).append(" ").append(c.getStreet());
//                arrayCinemasSpin[i] = String.valueOf(cinemaItem);
//                i += 1;
//            }
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
//     * one of the sections/tabs/pages.
//     */
//    public class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            // getItem is called to instantiate the fragment for the given page.
//            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);
//        }
//
//        @Override
//        public int getCount() {
//            // Show 3 total pages.
//            return 3;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "Kina";
//                case 1:
//                    return "Rezerwuj bilet";
//                case 2:
//                    return "Rezerwacje";
//            }
//            return null;
//        }
//
//
//    }
//}