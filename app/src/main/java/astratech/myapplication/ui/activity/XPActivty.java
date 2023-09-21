package astratech.myapplication.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import astratech.myapplication.R;

public class XPActivty extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xp);

        ImageView mBackButton = findViewById(R.id.backBtnXP);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ConstraintLayout constraintHistoryXP = findViewById(R.id.lihat_riwayat);
        constraintHistoryXP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(XPActivty.this, HistoryXPActivity.class);
                startActivity(intent);
            }
        });
        expandableListView = findViewById(R.id.expandableListView);

        // Persiapan data header dan child
        prepareListData();

        expandableListAdapter = new CustomExpandableListAdapter(this, listDataHeader, listDataChild);

        // Mengatur adapter untuk ExpandableListView
        expandableListView.setAdapter(expandableListAdapter);

        // Menangani klik pada item header
        expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            // Tindakan yang akan diambil saat header ditekan (misalnya, memperluas atau menyusutkan item)
            return false;
        });

        // Menangani klik pada item child
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, android.view.View v, int groupPosition, int childPosition, long id) {
                // Tindakan yang akan diambil saat item child ditekan
                String selectedItem = expandableListAdapter.getChild(groupPosition, childPosition).toString();
                return false;
            }
        });
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Tambahkan data header
        listDataHeader.add("Apa itu XP ?");
        listDataHeader.add("Bagaimana cara dapat XP ?");

        // Tambahkan data child
        List<String> child1 = new ArrayList<>();
        child1.add("XP, kependekan dari Experience Point adalah poin yang kami berikan untuk memberikan penghargaan kepada Improovers");

        List<String> child2 = new ArrayList<>();
        child2.add("Improovers dapat mendapatkan XP dengan mengungah sertifikat kegiatan ");

        listDataChild.put(listDataHeader.get(0), child1);
        listDataChild.put(listDataHeader.get(1), child2);
    }
    public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
        private Context context;
        private List<String> listDataHeader;
        private HashMap<String, List<String>> listDataChild;

        public CustomExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
            this.context = context;
            this.listDataHeader = listDataHeader;
            this.listDataChild = listDataChild;
        }

        @Override
        public int getGroupCount() {
            return listDataHeader.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return listDataChild.get(listDataHeader.get(groupPosition)).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return listDataHeader.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            String headerTitle = (String) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_item_group, null);
            }

            TextView textViewGroup = convertView.findViewById(R.id.textViewGroup);
            textViewGroup.setText(headerTitle);

            ImageView arrowIcon = convertView.findViewById(R.id.arrowIcon);
            if (isExpanded) {
                arrowIcon.setImageResource(R.drawable.baseline_arrow_drop_up_24); // Mengubah ikon jika grup diperluas
            } else {
                arrowIcon.setImageResource(R.drawable.baseline_arrow_drop_down_24); // Mengubah ikon jika grup tidak diperluas
            }

            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            String childText = (String) getChild(groupPosition, childPosition);
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_item_child, null);
            }

            TextView textViewChild = convertView.findViewById(R.id.textViewChild);
            textViewChild.setText(childText);

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
