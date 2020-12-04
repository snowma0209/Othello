package jp.codeforfun.othello;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class ResultDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.msg_revenge);
        builder.setPositiveButton(R.string.msg_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), getActivity().getClass());
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        builder.setNegativeButton(R.string.msg_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                getActivity().finish();
            }
        });
        return builder.create();
    }
 }


