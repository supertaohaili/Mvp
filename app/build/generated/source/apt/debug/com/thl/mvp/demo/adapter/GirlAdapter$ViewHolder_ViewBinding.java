// Generated code from Butter Knife. Do not modify!
package com.thl.mvp.demo.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.thl.mvp.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GirlAdapter$ViewHolder_ViewBinding<T extends GirlAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public GirlAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.ivGirl = Utils.findRequiredViewAsType(source, R.id.iv_girl, "field 'ivGirl'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivGirl = null;

    this.target = null;
  }
}
