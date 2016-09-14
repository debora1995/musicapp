package musicapp.views;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ferreiro on 03/06/16.
 */
public class Loc {
    private String name;
    private LatLng latLng;

    public String getName() {
        return name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Loc(String name, LatLng latLng){
        this.name = name;
        this.latLng = latLng;
    }

    @Override
    public String toString() {
        return "Loc{" +
                "name='" + name + '\'' +
                ", latLng=" + latLng +
                '}';
    }
}
