package com.gaolei.slidingmenu;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zhy_slidingmenu.R;

public class WXMessageAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private List<String> list;

	public WXMessageAdapter(List<String> list, Context context) {
		inflater = LayoutInflater.from(context);
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.wxmessage_item, null);
			holder.message_title = (TextView) convertView
					.findViewById(R.id.message_title);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		if (list.size() > 0) {
			holder.message_title.setText(list.get(position));
		}
		return convertView;

	}

	class ViewHolder {
		TextView message_title;
	}
}