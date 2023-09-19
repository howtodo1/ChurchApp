package com.example.test.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.R;
import com.example.test.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        View root = binding.getRoot();
        WebView webView1 = (WebView) rootView.findViewById(R.id.sermons);
        if (webView1 != null) { // Check if WebView1 is not null
            WebSettings webSettings1 = webView1.getSettings();
            webSettings1.setJavaScriptEnabled(true);
            webView1.loadUrl("https://stthomas-svale.org/worship-schedule/");
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}