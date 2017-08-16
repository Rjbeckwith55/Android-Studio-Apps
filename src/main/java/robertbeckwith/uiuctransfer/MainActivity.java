package robertbeckwith.uiuctransfer;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TableRow;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.graphics.Color;
import java.util.Collections;
import java.util.Comparator;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private ListView transferArrayListView;
    private TextView infoBox;
    private ProgressBar simpleProgressBar;
    private ArrayList<Transfers> transferArray = new ArrayList<Transfers>();
    private int counter;
    private CharSequence mTitle;
    private String note = "";
    private Boolean isLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.transferArrayListView = (ListView) findViewById(R.id.transferArrayListView);
        this.infoBox = (TextView) findViewById(R.id.txtInfo);
        this.simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
        this.infoBox.setText(getString(R.string.welcomeMessage));
        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();


        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        isLoaded = true;
    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        if (!isLoaded) {
            return;
        }

        String query = "";

        switch (position) {
            case 0:
                note = getString(R.string.selectAll);
                query = Queries.selectAll;
                break;
            case 1:
                note = getString(R.string.selectAllSS);
                query = Queries.selectAllSS;
                break;
            case 2:
                note = getString(R.string.selectAllHum);
                query = Queries.selectAllHum;
                break;
            case 3:
                note = getString(R.string.selectAllWCC);
                query = Queries.selectAllWCC;
                break;
            case 4:
                note = getString(R.string.selectAllNW);
                query = Queries.selectAllNW;
                break;
            case 5:
                note = getString(R.string.selectAllUS);
                query = Queries.selectAllUS;
                break;
            case 6:
                note = getString(R.string.selectTransfer);
                query = Queries.selectTransfers;
                break;
            case 7:
                note = getString(R.string.selectNoTransfer);
                query = Queries.selectNoTransfers;
                break;
        }

        if (!query.isEmpty()) {
            this.infoBox.setText("Downloading...");
            this.simpleProgressBar.setVisibility(View.VISIBLE);
            transferArray.clear();
            new DownloadWebpageTask(new AsyncResult() {
                @Override
                public void onResult(JSONObject object) {
                    processJson(object);
                }
            }).execute(query);
        }
    }

    public void onSectionAttached(int number) {

    }

    private void processJson(JSONObject object) {

        try {
            JSONArray rows = object.getJSONArray("rows");

            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");

                String symbol = columns.getJSONObject(0).getString("v");
                String name = columns.getJSONObject(1).getString("v");
                int code = columns.getJSONObject(2).getInt("v");
                String cod = columns.getJSONObject(3).getString("v");

                // general engineering classes
                if("NO".equals(cod) || "YES".equals(cod)||"SOME".equals(cod)){
                    String transferStatus = cod;
                    String description = columns.getJSONObject(4).getString("v");
                    String majors = columns.getJSONObject(5).getString("v");
                    Transfers m = new Transfers(symbol,name,code,transferStatus,description,majors);
                    transferArray.add(m);
                }
                else
                    // general elective credits
                {   String uiucsymbol = columns.getJSONObject(4).getString("v");
                    int uiuccode = columns.getJSONObject(5).getInt("v");
                    String ssHum = columns.getJSONObject(6).getString("v");
                    String westerneastern = columns.getJSONObject(7).getString("v");
                    String description = columns.getJSONObject(8).getString("v");
                    Transfers m = new Transfers(symbol,name,code,cod,uiucsymbol,uiuccode,ssHum,westerneastern,description);
                    transferArray.add(m);}


            }
            // adds blank textviews to make the data scrollable for the filters with few classes
            for (int i =0; i < 17-rows.length();i++){
                Transfers m = new Transfers("","",0,"","",0,"","","");
                transferArray.add(m);
            }

            final TransfersAdapter adapter = new TransfersAdapter(this, R.layout.transfers, transferArray,counter);
            transferArrayListView.setAdapter(adapter);
            this.simpleProgressBar.setVisibility(View.GONE);
            this.infoBox.setText(this.note);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
   /* private void processJson2(JSONObject object) {

        try {
            JSONArray rows = object.getJSONArray("rows");

            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");

                String symbol = columns.getJSONObject(0).getString("v");
                String name = columns.getJSONObject(1).getString("v");
                int code = columns.getJSONObject(2).getInt("v");
                String transferStatus = columns.getJSONObject(3).getString("v");
                Transfers m = new Transfers(symbol,name,code,transferStatus);
                transferArray.add(m);
            }
            final TransfersAdapter adapter = new TransfersAdapter(this, R.layout.transfers, transferArray,counter);
            transferArrayListView.setAdapter(adapter);
            this.simpleProgressBar.setVisibility(View.GONE);
            this.infoBox.setText(this.note);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
*/
    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }

    }


}