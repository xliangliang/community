package com.liangliang.community.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CFollowerFansRelation implements Serializable {
    private Long id;

    @ApiModelProperty(value = "被关注者id")
    private Long followId;

    @ApiModelProperty(value = "粉丝id")
    private Long fansId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public Long getFansId() {
        return fansId;
    }

    public void setFansId(Long fansId) {
        this.fansId = fansId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", followId=").append(followId);
        sb.append(", fansId=").append(fansId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}