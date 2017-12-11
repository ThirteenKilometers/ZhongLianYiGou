package com.lzhs.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author ${俞欢} QQ:2366081200
 * @name ZhongLianYiGou
 * @class describe:
 * @time 2017/12/10 16:56
 * @chang time
 * @change class describe:
 */

public class FruitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  public   static  final  int TYPE_01=0x1a;
    public   static  final  int TYPE_02=0x2a;
    private  static  final  int TYPE_013=0x3a;

    public FruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }
     public OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface  OnItemClickListener{
        void OnItemClick(View view, int postion);
     }
    private List<Fruit>fruitList;
      class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView fruitImage;
        TextView fruitName;
          int viewtype;
        public ViewHolder(View itemView,int viewtype) {
            super(itemView);
            this.viewtype=viewtype;
            fruitImage=itemView.findViewById(R.id.fruit_image);
            fruitName=itemView.findViewById(R.id.fruit_name);
            itemView.setOnClickListener(this);
        }

          @Override
          public void onClick(View view) {
              if (onItemClickListener != null) {
                  onItemClickListener.OnItemClick(null,viewtype);
              }

          }
      }
      class  ViewHolder02 extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        public ViewHolder02(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null) {
                onItemClickListener.OnItemClick(itemView,TYPE_02);
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       if (viewType==TYPE_01){
           View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
           ViewHolder holder=new ViewHolder(view,viewType);
           return holder;
       }else {
           View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item_02,parent,false);
           ViewHolder02 holder=new ViewHolder02(view);
           return holder;
       }

    }

    @Override
    public void onBindViewHolder(final  RecyclerView.ViewHolder  holder, int position) {

        Fruit fruit=fruitList.get(position);
       if (getItemViewType(position)==TYPE_01){
           ((ViewHolder) holder).fruitImage.setImageResource(fruit.getImgId());
           ((ViewHolder) holder).fruitName.setText(fruit.getName());


       }else  if (getItemViewType(position)==TYPE_02){
           ((ViewHolder02) holder).textView.setText(fruit.getName());

       }

       /* if (onItemClickListener!=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int  pos=holder.getLayoutPosition();
                    onItemClickListener.OnItemClick(holder.itemView,pos);
                }
            });
        }*/

    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (fruitList.get(position).getType()==0) {
            return TYPE_01;
        }else {
            return TYPE_02;
        }
    }
}
