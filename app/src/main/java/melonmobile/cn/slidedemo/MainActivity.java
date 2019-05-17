package melonmobile.cn.slidedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, DemoFragment.newInstance(0));
        fragmentTransaction.commit();
    }

    public void changFragment(int type){
        DemoFragment demoFragment1 = DemoFragment.newInstance(type);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        FragmentTransaction fragmentTransaction1 = fragmentTransaction.setCustomAnimations(R.anim.slid_top_in, R.anim.slid_bottom_out,
                R.anim.slid_bottom_in, R.anim.slid_top_out);
        fragmentTransaction1.isEmpty();
        if (!demoFragment1.isAdded()) {
            fragmentTransaction1.add(R.id.frameLayout, demoFragment1,type+"");
        }
        Fragment fragmentByTag = supportFragmentManager.findFragmentByTag((type - 1) + "");
        if (fragmentByTag!=null){
            fragmentTransaction1.hide(fragmentByTag);
        }
        fragmentTransaction1.show(demoFragment1);
        fragmentTransaction.commit();
    }

    public void returnFragment(int type){
        DemoFragment demoFragment2 = DemoFragment.newInstance(type);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentTransaction fragmentTransaction1 = fragmentTransaction.setCustomAnimations(R.anim.slid_bottom_in, R.anim.slid_top_out, R.anim.slid_top_in, R.anim.slid_bottom_out);
        if (!demoFragment2.isAdded()) {
            fragmentTransaction1.add(R.id.frameLayout, demoFragment2,type+"");
        }
        Fragment fragmentByTag = getSupportFragmentManager().findFragmentByTag((type + 1) + "");
        if (fragmentByTag!=null){
            fragmentTransaction1.hide(fragmentByTag);
        }
        fragmentTransaction1.show(demoFragment2);
        fragmentTransaction.commit();
    }
}
