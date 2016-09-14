package musicapp.constants;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Pili on 31/05/2016.
 */
public class InternetConnections {

    /**
     * Search if internet is on
     * @param context
     * @return true if internet is on (boolean)
     */
    public static boolean searchConexion(Context context) {

        boolean connected = false;

        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // search every network
        NetworkInfo[] network = connec.getAllNetworkInfo();

        for (int i = 0; i < network.length; i++) {
            // true if network is connected
            if (network[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }


}
