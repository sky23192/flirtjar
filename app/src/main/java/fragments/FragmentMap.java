package fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.flirtjar.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rutvik on 2/1/2017 at 6:26 PM.
 */

public class FragmentMap extends Fragment implements OnMapReadyCallback
{

    SyncedMapFragment syncedMapFragment;
    @BindView(R.id.tv_meetUpTo)
    TextView tvMeetUpTo;
    @BindView(R.id.fam_meetUpTo)
    FloatingActionMenu famMeetUpTo;
    @BindView(R.id.fab_detour)
    FloatingActionButton fabDetour;
    private GoogleMap mMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);

        syncedMapFragment = (SyncedMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.frag_map);

        syncedMapFragment.getMapAsync(this);

        final Typeface pacifico = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Pacifico-Regular.ttf");

        tvMeetUpTo.setTypeface(pacifico);

        famMeetUpTo.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener()
        {
            @Override
            public void onMenuToggle(boolean opened)
            {
                if (opened)
                {
                    tvMeetUpTo.setVisibility(View.VISIBLE);
                } else
                {
                    tvMeetUpTo.setVisibility(View.GONE);
                }
            }
        });

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.getUiSettings().setTiltGesturesEnabled(true);

        LatLng gujarat = new LatLng(23.012068, 72.5789153);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gujarat, 11));

    }
}
