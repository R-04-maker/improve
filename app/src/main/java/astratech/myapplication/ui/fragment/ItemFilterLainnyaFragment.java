package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import astratech.myapplication.R;
import astratech.myapplication.model.Event;
import astratech.myapplication.ui.activity.DetailLombaActivity;

public class ItemFilterLainnyaFragment extends Fragment {
    private static final String KEY_SEARCH = "search-value";
    private String data = "";
    private RecyclerView mRvFilterLainnya;
    private EventAdapter mEventAdapter;
    private List<Event> mEventList;

    public ItemFilterLainnyaFragment() {
    }

    @SuppressWarnings("unused")
    public static ItemFilterLainnyaFragment newInstance(String data) {
        ItemFilterLainnyaFragment fragment = new ItemFilterLainnyaFragment();
        Bundle args = new Bundle();
        args.putString(KEY_SEARCH, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            data = getArguments().getString(KEY_SEARCH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_filter_lainnya, container, false);

        mRvFilterLainnya = view.findViewById(R.id.rv_filter_event_lain);
        mRvFilterLainnya.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFilterLainnya.setAdapter(mEventAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEventList = dataEvent();
        // Update RV
        mEventAdapter = new EventAdapter(mEventList);
        mRvFilterLainnya.setAdapter(mEventAdapter);
    }

    public List<Event> dataEvent() {
        List<Event> eventList = new ArrayList<>();
        for(int i  = 0; i < 5; i++){
            Event event = new Event();
            event.setIdEvent("" + i + 1);
            event.setNamaEvent("Lomba " + i);
            eventList.add(event);
        }
        return eventList;
    }
    private class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder>{
        private List<Event> mEvents;

        public EventAdapter(List<Event> events){
            mEvents = events;
        }

        @NonNull
        @Override
        public EventAdapter.EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new EventAdapter.EventHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull EventAdapter.EventHolder holder, int position) {
            Event event = mEvents.get(position);
            holder.bind(event);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);
        }

        @Override
        public int getItemCount() {
            return mEvents.size();
        }

        private class EventHolder extends RecyclerView.ViewHolder{
            private ImageView mPoster;
            private TextView mNamaEvent;
            private Event mEvent;

            public EventHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_card_event, parent, false));

                mPoster = itemView.findViewById(R.id.cover_book_list_view);
                mNamaEvent = itemView.findViewById(R.id.nama_lomba);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(getContext(), DetailLombaActivity.class);
//                        intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                        startActivity(intent);
                    }
                });
            }
            public void bind(Event event){
                mEvent = event;
                mNamaEvent.setText(event.getNamaEvent());
            }
        }
    }

}
