package org.xtimms.kabegami.helper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.ref.WeakReference;

public class SaveHelper implements Target {

    private final Context context;
    private final WeakReference<AlertDialog> alertDialogWeakReference;
    private final WeakReference<ContentResolver> contentResolverWeakReference;
    private final String name;
    private final String desc;

    public SaveHelper(Context context, AlertDialog alertDialog, ContentResolver contentResolver, String name, String desc) {
        this.context = context;
        this.alertDialogWeakReference = new WeakReference<>(alertDialog);
        this.contentResolverWeakReference = new WeakReference<>(contentResolver);
        this.name = name;
        this.desc = desc;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        ContentResolver r = contentResolverWeakReference.get();
        AlertDialog alertDialog = alertDialogWeakReference.get();
        if (r != null) {
            MediaStore.Images.Media.insertImage(r, bitmap, name, desc);
        }
        alertDialog.dismiss();
        Toast.makeText(context, "Download success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBitmapFailed(Exception e, Drawable errorDrawable) {

    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }

}
