package melonmobile.cn.slidedemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slid_top_in,R.anim.slid_bottom_out,
                R.anim.slid_bottom_in,R.anim.slid_top_out)
                .replace(R.id.frameLayout, DemoFragment.newInstance(type));
        fragmentTransaction.commit();
    }

    public void returnFragment(int type){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slid_bottom_in,R.anim.slid_top_out,R.anim.slid_top_in,R.anim.slid_bottom_out)
                .replace(R.id.frameLayout, DemoFragment.newInstance(type));
        fragmentTransaction.commit();
    }
}
