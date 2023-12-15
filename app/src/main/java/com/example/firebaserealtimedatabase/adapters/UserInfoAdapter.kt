package com.example.firebaserealtimedatabase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaserealtimedatabase.R
import com.example.firebaserealtimedatabase.models.UserInfo

class UserInfoAdapter( val userDataList: ArrayList<UserInfo> ,var mListener:onItemClickListener ):RecyclerView.Adapter<UserInfoAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.adapter_layout,parent,false)
        return MyViewHolder(view)


    }

    override fun getItemCount(): Int {
        return userDataList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text=userDataList[position].name
        holder.fatherName.text=userDataList[position].fname
        holder.phoneNo.text=userDataList[position].phoneNo.toString()
        holder.eMail.text=userDataList[position].email
        holder.delRecord.setOnClickListener(){
            mListener.onDeleteIconClick(position,userDataList[position])

        }
        holder.itemClick.setOnClickListener(){
            mListener.onItemClick(position ,userDataList[position])

        }

    }
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name:TextView =itemView.findViewById(R.id.tv_name)
        val fatherName:TextView =itemView.findViewById(R.id.tv_fname)
        val phoneNo:TextView =itemView.findViewById(R.id.tv_phoneNo)
        val eMail:TextView =itemView.findViewById(R.id.tv_email)
        val delRecord:ImageView=itemView.findViewById(R.id.delRecord)
        val itemClick:LinearLayout=itemView.findViewById(R.id.itemClick)

    }
    interface onItemClickListener{

        fun onDeleteIconClick(position: Int, userInfo: UserInfo)
        fun onItemClick(position: Int, userInfo: UserInfo)

    }


}