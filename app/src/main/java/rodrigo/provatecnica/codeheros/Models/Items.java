package rodrigo.provatecnica.codeheros.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Items implements Serializable {

    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("type")
    private String type;

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
