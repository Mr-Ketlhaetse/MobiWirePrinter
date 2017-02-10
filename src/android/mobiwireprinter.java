package cordova-plugin-mobiwire-print;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.nbbse.printer.Printer;

/**
 * This class echoes a string called from JavaScript.
 */
public class MobiWirePrinter extends CordovaPlugin 
{

    private Printer printerObj = Printer.getInstance();

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException 
    {
        if (action.equals("printTicket")) 
        {
            String message = args.getString(0);
            this.printTicket(message, callbackContext);
            return true;
        }
        return false;
    }

    private void printTicket(String message, CallbackContext callbackContext) 
    {
        if (message != null && message.length() > 0) 
        {
            if (printerObj.getPaperStatus() == 1) 
            {
                printerObj.printText(" printer test", 3);
                callbackContext.success(message);
            }

        } 

        else 
        {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
