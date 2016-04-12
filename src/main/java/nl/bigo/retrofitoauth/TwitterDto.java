package nl.bigo.retrofitoauth;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tonythompson on 4/12/16.
 */
public class TwitterDto {

    private String created_at;
    private String id_str;
    private String text;

    public String getAliceSource() {
        return aliceSource;
    }

    public void setAliceSource(String aliceSource) {
        this.aliceSource = aliceSource;
    }

    @SerializedName("source")
    private String aliceSource;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
