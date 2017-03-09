package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rutvik on 3/9/2017 at 1:37 PM.
 */

class NotificationListAdapter<T> extends RecyclerView.Adapter
{


    final Context contest;

    final List<T> itemList;

    public NotificationListAdapter(final Context context)
    {
        this.contest = context;
        itemList = new ArrayList<>();
    }

    public void addItem(T item)
    {
        itemList.add(item);
        notifyItemInserted(itemList.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return itemList.size();
    }

}
