package com.example.nehal.sportsapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SpinnerHintAdapter extends ArrayAdapter<String> {
    private boolean isMissing;
    private Context context;
    private View hintView;

    public SpinnerHintAdapter(Context theContext, String[] objects, int theLayoutResId) {
        super(theContext, theLayoutResId, objects);

        this.context = theContext;
    }

    public SpinnerHintAdapter(Context context, List<String> objects, int resource) {
        super(context, resource, objects);
        this.context = context;
    }

    public void isMissing(boolean isMissing) {
        this.isMissing = isMissing;
    }

    @Override
    public int getCount() {
        // don't display last item. It is used as hint.
        int count = super.getCount();
        return count > 0 ? count - 1 : count;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        if (position == getCount()) {
            TextView hintView = (TextView) view;
            this.hintView = hintView;
            if (isMissing)
                hintView.setTextColor(context.getResources().getColor(R.color.missing_field_color));
        }
        return view;
    }

    public TextView getHintView() {
        return (TextView) hintView;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView tv = (TextView) view;
        if (position == (getCount()) && isMissing) {
            //tv.setTextColor(context.getResources().getColor(R.color.missing_field_color));
            //tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.missing_dropdown, 0);
        }
        return view;
    }
}