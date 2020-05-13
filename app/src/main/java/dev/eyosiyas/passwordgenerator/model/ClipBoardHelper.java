package dev.eyosiyas.passwordgenerator.model;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

public class ClipBoardHelper {
    private Context context;

    public ClipBoardHelper(Context context) {
        this.context = context;
    }

    public void setClipboard(String text) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("password", text);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(context, "Password copied to clipboard!", Toast.LENGTH_SHORT).show();
    }
}