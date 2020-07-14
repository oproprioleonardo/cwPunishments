package me.centralworks.modules.punishments.models.punishs.supliers.cached;

import com.google.common.collect.Lists;
import me.centralworks.modules.punishments.models.punishs.supliers.Reason;

import java.util.List;

public class Reasons {

    protected static Reasons instance;
    public List<Reason> reasons = Lists.newArrayList();

    public static Reasons getInstance() {
        if (instance == null) instance = new Reasons();
        return instance;
    }

    public List<Reason> getReasons() {
        return reasons;
    }

    public void setReasons(List<Reason> reasons) {
        this.reasons = reasons;
    }

    public boolean exists(String reason) {
        return getReasons().stream().anyMatch(pr -> pr.getReason().equalsIgnoreCase(reason));
    }

    public Reason getByReason(String reason) {
        return getReasons().stream().filter(pr -> pr.getReason().equalsIgnoreCase(reason)).findFirst().orElse(new Reason(reason));
    }

}
