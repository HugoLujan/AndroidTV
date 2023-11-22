package com.example.myapplication;

import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.BaseCardView;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;


public class MainFragment extends BrowseSupportFragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pantallaInicio();
    }
    private void pantallaInicio() {
        setTitle("Hugo");
        setHeadersState(HEADERS_ENABLED);
        setBrandColor(getResources().getColor(android.R.color.holo_blue_dark));
        cargarDatos();
    }
    private void cargarDatos() {
        HeaderItem categoria_1 = new HeaderItem(0,"Comedia");
        HeaderItem categoria_2 = new HeaderItem(1,"Terror");
        HeaderItem categoria_3 = new HeaderItem(2,"Acción");
        HeaderItem categoria_4 = new HeaderItem(3,"Suspenso");
        HeaderItem categoria_5 = new HeaderItem(4,"Familiar");

        ArrayObjectAdapter fila_1 = new ArrayObjectAdapter(new MyPresenter());
        fila_1.add(new SingleRowView("Promocion Netflix",
                getResources().getDrawable(R.mipmap.img,getContext().getTheme())));
        ArrayObjectAdapter windowAdapter = new ArrayObjectAdapter( new ListRowPresenter());
                windowAdapter.add(new ListRow(categoria_1, fila_1));
        setAdapter(windowAdapter);
    }

    private class MyPresenter extends Presenter {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
            ImageCardView icv = new ImageCardView(viewGroup.getContext());
            icv.setCardType(BaseCardView.CARD_TYPE_INFO_UNDER_WITH_EXTRA);
            icv.setInfoVisibility(BaseCardView.CARD_REGION_VISIBLE_ACTIVATED);
            return new ViewHolder(icv);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object object) {
            SingleRowView srv = (SingleRowView) object;
            ImageCardView icv = ((ImageCardView) viewHolder.view);
            icv.setMainImage(srv.getImage());
            icv.setMainImageDimensions(313,176);
            icv.setTitleText(srv.getName());
            icv.setContentText("Descripcion de la pelicula");
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }
}