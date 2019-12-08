package rodrigo.provatecnica.codeheros.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MarvelHeros {
    @SerializedName("code")
    private float code;
    @SerializedName("status")
    private String status;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("attributionText")
    private String attributionText;
    @SerializedName("attributionHTML")
    private String attributionHTML;
    @SerializedName("etag")
    private String etag;
    @SerializedName("data")
    private DataObject DataObject;


    public rodrigo.provatecnica.codeheros.Models.DataObject getDataObject() {
        return DataObject;
    }

    public void setDataObject(rodrigo.provatecnica.codeheros.Models.DataObject dataObject) {
        DataObject = dataObject;
    }

    public float getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public String getEtag() {
        return etag;
    }

    public rodrigo.provatecnica.codeheros.Models.DataObject getData() {
        return DataObject;
    }

    public void setCode(float code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public void setData(rodrigo.provatecnica.codeheros.Models.DataObject dataObject) {
        this.DataObject = dataObject;
    }
}


