package com.example.parkingsystemjava.mvp.view.base;

import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;

public class FragmentView {
    private WeakReference<Fragment> fragmentRef;

    public FragmentView(Fragment fragment) {
        this.fragmentRef = new WeakReference<>(fragment);
    }

    public Fragment getFragment() {
        return this.fragmentRef.get();
    }
}
