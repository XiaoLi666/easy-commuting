package sg.edu.ntu.cz2006.seproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by koAllen on 24/3/16.
 */
public class Leg {

    @SerializedName("duration")
    private Duration mDuration;

    @SerializedName("steps")
    private List<Step> mSteps;

    public Duration getDuration() {
        return mDuration;
    }

    public List<Step> getSteps() {
        return mSteps;
    }
}
