package robertbeckwith.uiuctransfer;
import org.json.JSONObject;

interface AsyncResult
{
    void onResult(JSONObject object);
}