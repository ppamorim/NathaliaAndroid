package nathalia_android.ppamorim.github.com.minhalistinhabonitinha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class DogAdapter extends BaseAdapter {
  private String[] urls = new String[]{
      "https://s-media-cache-ak0.pinimg.com/236x/42/c5/36/42c536089c9277590a456004599cf3a1.jpg",
      "https://s-media-cache-ak0.pinimg.com/236x/60/d2/4f/60d24f3635c7b387f6c3df513b66581e.jpg",
      "https://files.graphiq.com/465/media/images/t2/Labrador_Retriever_4922645.jpg"};

  @Override public int getCount() {
    return urls.length;
  }

  @Override public String getItem(int i) {
    return urls[i];
  }

  @Override public long getItemId(int i) {
    return 0;
  }

  @Override public View getView(int i, View view, ViewGroup viewGroup) {

    ViewHolder viewHolder;

    if (view == null) {
      view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_dog, viewGroup, false);
      viewHolder = new ViewHolder(view);
      view.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) view.getTag();
    }

    viewHolder.load(viewGroup.getContext(), getItem(i));

    return view;
  }

  static class ViewHolder {

    ImageView image;
    TextView name;

    public ViewHolder(View view) {
      image = (ImageView) view.findViewById(R.id.image);
      name = (TextView) view.findViewById(R.id.dog_name);
    }

    public void load(Context context, String url) {
      Picasso.with(context).load(url).into(image);

    }

  }

}
