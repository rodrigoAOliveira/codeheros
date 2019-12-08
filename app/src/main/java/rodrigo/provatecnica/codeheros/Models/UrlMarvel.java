package rodrigo.provatecnica.codeheros.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UrlMarvel implements Serializable {
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
