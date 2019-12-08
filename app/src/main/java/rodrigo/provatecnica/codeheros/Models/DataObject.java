package rodrigo.provatecnica.codeheros.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataObject {
    @SerializedName("offset")
    private float offset;
    @SerializedName("limit")
    private float limit;
    @SerializedName("total")
    private float total;
    @SerializedName("count")
    private float count;
    @SerializedName("results")
    private ArrayList<Result> results;


    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public float getOffset() {
        return offset;
    }

    public float getLimit() {
        return limit;
    }

    public float getTotal() {
        return total;
    }

    public float getCount() {
        return count;
    }

    // Setter Methods

    public void setOffset(float offset) {
        this.offset = offset;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setCount(float count) {
        this.count = count;
    }
}