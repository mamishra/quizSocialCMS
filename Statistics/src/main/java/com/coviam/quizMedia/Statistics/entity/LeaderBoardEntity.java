package com.coviam.quizMedia.Statistics.entity;

import com.coviam.quizMedia.Statistics.dto.LeaderBoardDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = LeaderBoardEntity.COLLECTION_NAME)
public class LeaderBoardEntity {

    public final static String COLLECTION_NAME="LeaderBoard";

    @Id
    private String id;
    private String leaderBoardName;
    private List<LeaderBoardDto> leadersDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeaderBoardName() {
        return leaderBoardName;
    }

    public void setLeaderBoardName(String leaderBoardName) {
        this.leaderBoardName = leaderBoardName;
    }

    public List<LeaderBoardDto> getLeadersDetails() {
        return leadersDetails;
    }

    public void setLeadersDetails(List<LeaderBoardDto> leadersDetails) {
        this.leadersDetails = leadersDetails;
    }
}
