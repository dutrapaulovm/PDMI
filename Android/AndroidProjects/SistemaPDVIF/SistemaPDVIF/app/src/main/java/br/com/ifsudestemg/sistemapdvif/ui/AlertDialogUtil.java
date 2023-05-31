package br.com.ifsudestemg.sistemapdvif.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class AlertDialogUtil {

    public static void showMessageYesNo(Context ctx,
          String title, String msg,
          DialogInterface.OnClickListener  lyes,
          DialogInterface.OnClickListener  lno){

        AlertDialog.Builder dlg = new AlertDialog.Builder(ctx);
        dlg.setTitle(title);
        dlg.setMessage(msg);
        dlg.setPositiveButton("Sim", lyes);
        dlg.setNegativeButton("Não", lno);
        dlg.show();
    }




}
