package jp.codeforfun.othello;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.DialogFragment;

public class SurrenderDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.msg_pass);
        builder.setPositiveButton(R.string.msg_yes,new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int id){
                listener.onDialogPositiveClick(SurrenderDialogFragment.this);
            }
        });
        builder.setNegativeButton(R.string.msg_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                listener.onDialogNegativeClick(SurrenderDialogFragment.this);
            }
        });
        return builder.create();
    }

    public interface NoticeDialogListener{
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    NoticeDialogListener listener;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try {
            listener = (NoticeDialogListener)context;
        }catch (ClassCastException e){
            throw  new ClassCastException(context.toString()+"must implement NoticeDialogListener");
        }
    }

}
