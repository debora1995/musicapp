package musicapp.constants;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import musicapp.views.Loc;

/**
 * Created by Pili on 31/05/2016.
 */
public class Constants {

    public static final String nameUserFile = "Login";
    public static final int version = 1;


    static List<Loc> locsList = new ArrayList<Loc>();

    public Constants(){
        locsList.add(new Loc("Barcelona", new LatLng(41.385061, 2.173407)));
        locsList.add(new Loc("Boveda", new LatLng(41.398532, 2.200075)));
        locsList.add(new Loc("Sr Lobo", new LatLng(41.395956, 2.188540)));
        locsList.add(new Loc("Otto Zutz", new LatLng(41.400419, 2.150036)));
        locsList.add(new Loc("Razzmatazz", new LatLng(41.397790, 2.191043)));
        locsList.add(new Loc("Ceferino", new LatLng(41.396812, 2.191220)));
        locsList.add(new Loc("Hijos de Caín", new LatLng(41.396746, 2.191858)));
/*        locsList.add(new Loc("", new LatLng(,)));
        locsList.add(new Loc("", new LatLng(,)));
        locsList.add(new Loc("", new LatLng(,)));
        locsList.add(new Loc("", new LatLng(,)));
        locsList.add(new Loc("", new LatLng(,)));
        locsList.add(new Loc("", new LatLng(,)));
        locsList.add(new Loc("", new LatLng(,)));
        locsList.add(new Loc("", new LatLng(,)));
        locsList.add(new Loc("", new LatLng(,)));
        locsList.add(new Loc("", new LatLng(,)));
*/
    }

    public static List<Loc> getLocsList() {
        return locsList;
    }

}
