package rodrigo.provatecnica.codeheros.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Information implements Serializable {
    @Expose
    @SerializedName("available")
    private int available;
    @Expose
    @SerializedName("collectionURI")
    private String collectionURI;
    @Expose
    @SerializedName("items")
    private ArrayList<Items> items;
    @SerializedName("returned")
    private int returned;

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }
}
