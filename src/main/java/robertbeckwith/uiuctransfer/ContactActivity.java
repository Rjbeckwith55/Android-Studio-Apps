package robertbeckwith.uiuctransfer;

/**
 * Created by rjbec on 5/9/2017.
 */
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
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ContactActivity extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.getWindow().getDecorView().findViewById(android.R.id.content);
        findViewById(android.R.id.content);
            setContentView(R.layout.activity_contact);


    }
}
