package com.xyl.fly;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

/**
 * MainActivity:主页面容器
 *
 * @author xyl
 * @date 2021-08-20
 */
public class MainActivity extends AppCompatActivity {

    private NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.main_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mNavController = Navigation.findNavController(this, R.id.fragmentContainerView);
        NavigationUI.setupActionBarWithNavController(this, mNavController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return mNavController.navigateUp();
    }
}