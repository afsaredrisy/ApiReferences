package co.myapp.assignement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import co.myapp.assignement.viewModel.Attendance;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Attendance[] attendances;
    private Context context;
    public Adapter(Context context){
        this.context=context;
    }

    public void setAttendance(Attendance[] attendance) {
        this.attendances = attendance;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from ( parent.getContext() );
        View view=layoutInflater.inflate (R.layout.attance_view_row,parent,false );
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Attendance attendance = attendances[position];
        holder.className.setText(attendance.getClassName());
        holder.totalLecture.setText("TotalLectures: "+attendance.getTotalLectures());
        holder.late.setText("Late: "+attendance.getLate());
        holder.sick.setText("Sick: "+attendance.getSick());
        holder.present.setText("Present: "+attendance.getPresent());
        holder.absent.setText("Absent: "+attendance.getAbsent());
    }

    @Override
    public int getItemCount() {
        if(attendances==null){
            return 0;
        }
        return attendances.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView className,totalLecture,sick,present,late,absent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            className = itemView.findViewById(R.id.name);
            totalLecture = itemView.findViewById(R.id.tlec);
            present=itemView.findViewById(R.id.present);
            sick =itemView.findViewById(R.id.sick);
            late=itemView.findViewById(R.id.late);
            absent = itemView.findViewById(R.id.absent);
        }
    }

}
