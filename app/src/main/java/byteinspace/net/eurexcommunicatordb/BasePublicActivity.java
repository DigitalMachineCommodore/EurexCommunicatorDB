package byteinspace.net.eurexcommunicatordb;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by conta on 22.02.2017.
 */

public abstract class BasePublicActivity extends AppCompatActivity {

    private Toolbar toolbar;
    protected ListView drawerList;
    private ArrayAdapter<String> drawerAdapter;

    private ActionBarDrawerToggle mDrawerToggle;
    protected DrawerLayout mDrawerLayout;
    protected String mActivityTitle;

    protected void createDrawer() {
        String[] osArray = { "Android", "iOS", "Windows", "OS X", "Linux" };
        drawerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        drawerList.setAdapter(drawerAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setupDrawer();

    }

    protected void showToolbar(Toolbar toolbar) {

        this.toolbar = toolbar;

        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {


            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.news:
                        showNews();
                        return true;
                    case R.id.eurexclearinglogon:
                        showLogon();
                        return true;
                    case R.id.eurexlogon:
                        showLogon();
                        return true;
                    case R.id.xetralogon:
                        showLogon();
                        return true;
                    case R.id.mainindices:
                        showIndices(Constants.MAIN);
                        return true;
                    case R.id.futures:
                        showFutures();
                        return true;
                    case R.id.options:
                        showIndices(Constants.OPTIONS);
                        return true;
                }
                return false;
            }
        });
    }

    protected void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
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

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showNews() {
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
    private void showIndices(String target) {
        Intent intent = new Intent(this, IndexTickerActivity.class);
        intent.putExtra(Constants.KEY, target);
        startActivity(intent);
    }

    private void showFutures() {
        Intent intent = new Intent(this, FuturesOverviewActivity.class);
        startActivity(intent);
    }

    private void showLogon() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_public, menu);
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
        return true;
    }
}

