package me.centralworks.modules.punishments.models.punishs;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import me.centralworks.modules.punishments.models.punishs.supliers.PunishmentReason;
import me.centralworks.modules.punishments.models.punishs.supliers.cached.Reasons;
import me.centralworks.modules.punishments.models.punishs.supliers.enums.PunishmentState;
import me.centralworks.modules.punishments.models.punishs.supliers.enums.PunishmentType;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class PunishmentData {

    private Long startedAt;
    private Long finishAt;
    private String reason;
    private String punisher;
    private PunishmentState punishmentState;
    private List<String> evidences = Lists.newArrayList();
    private PunishmentType punishmentType;
    private boolean permanent;

    public String getReasonString() {
        return this.reason;
    }

    public PunishmentReason getReason() {
        return Reasons.getInstance().getByReason(getReasonString());
    }

    public Date getStartDate() {
        return new Date(getStartedAt());
    }

    public Date getFinishDate() {
        return new Date(getFinishAt());
    }

    public Timestamp getStartDateSQL() {
        return new Timestamp(getStartedAt());
    }

    public Timestamp getFinishDateSQL() {
        return new Timestamp(getFinishAt());
    }

    public String getEvidencesFinally() {
        return getEvidences().isEmpty() ? "Nenhuma anexada" : evidences.get(0);
    }


}
