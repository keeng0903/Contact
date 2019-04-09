package com.example.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ADMIN on 4/1/2019.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
    private ArrayList<Contact> mContacts;
    private Context mContext;
    private LayoutInflater mInflater;

    public ContactsAdapter(ArrayList<Contact> mContacts, Context mContext) {
        this.mContacts = mContacts;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.item_contact,
                viewGroup, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ContactViewHolder holder, int i) {
        Contact contact = mContacts.get(i);
        holder.tvTitle.setText(contact.getmTitle());
        holder.tvFullname.setText(contact.getmFullname());
        holder.tvCompany.setText(contact.getmCompany());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvFullname;
        TextView tvCompany;

        public ContactViewHolder(View itemView){
            super(itemView);
            itemView.setClickable(true);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvFullname = (TextView) itemView.findViewById(R.id.tv_fullname);
            tvCompany = (TextView) itemView.findViewById(R.id.tv_company);
        }
    }
}


//package com.example.admin.contactwithintent;

//        import android.content.Context;
//        import android.content.Intent;
//        import android.os.Bundle;
//        import android.support.v7.widget.RecyclerView;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.TextView;
//
//        import java.util.ArrayList;
//
///**
// * Created by ADMIN on 4/1/2019.
// */
//
//public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
//    private ArrayList<Contact> mContacts;
//    private Context mContext;
//    private LayoutInflater mInflater;
//
//    public ContactAdapter(ArrayList<Contact> mContacts, Context mContext) {
//        this.mContacts = mContacts;
//        this.mContext = mContext;
//        this.mInflater = LayoutInflater.from(mContext);
//    }
//
//    @Override
//    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View itemView = mInflater.inflate(R.layout.item_list_contact,
//                viewGroup, false);
//        return new ContactViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(ContactAdapter.ContactViewHolder holder, int i) {
//        Contact contact = mContacts.get(i);
//        holder.tvTitle.setText(contact.getmTitle());
//        holder.tvFullname.setText(contact.getmFullName());
//        holder.tvCompany.setText(contact.getmCompany());
//    }
//
//    @Override
//    public int getItemCount() {
//        return mContacts.size();
//    }
//
//    public class ContactViewHolder extends RecyclerView.ViewHolder{
//        TextView tvTitle;
//        TextView tvFullname;
//        TextView tvCompany;
//
//        public ContactViewHolder(View itemView){
//            super(itemView);
//            itemView.setClickable(true);
//            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
//            tvFullname = (TextView) itemView.findViewById(R.id.tv_fullname);
//            tvCompany = (TextView) itemView.findViewById(R.id.tv_company);
//        }
//    }
//}
