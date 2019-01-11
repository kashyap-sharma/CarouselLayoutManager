package boon.com.vp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;




public class DefaultChildSelectionListener  extends CarouselChildSelectionListener {

    @NonNull
    private final DefaultChildSelectionListener.OnCenterItemClickListener mOnCenterItemClickListener;

    protected DefaultChildSelectionListener(@NonNull final DefaultChildSelectionListener.OnCenterItemClickListener onCenterItemClickListener, @NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager) {
        super(recyclerView, carouselLayoutManager);

        mOnCenterItemClickListener = onCenterItemClickListener;
    }

    @Override
    protected void onCenterItemClicked(@NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager, @NonNull final View v) {
        mOnCenterItemClickListener.onCenterItemClicked(recyclerView, carouselLayoutManager, v);
    }

    @Override
    protected void onBackItemClicked(@NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager, @NonNull final View v) {
        recyclerView.smoothScrollToPosition(carouselLayoutManager.getPosition(v));
    }

    public static DefaultChildSelectionListener initCenterItemListener(@NonNull final DefaultChildSelectionListener.OnCenterItemClickListener onCenterItemClickListener, @NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager) {
        return new DefaultChildSelectionListener(onCenterItemClickListener, recyclerView, carouselLayoutManager);
    }

    public interface OnCenterItemClickListener {

        void onCenterItemClicked(@NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager, @NonNull final View v);
    }
}