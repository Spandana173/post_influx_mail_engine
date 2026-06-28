package com.spandana.post_influx.repository;

import com.spandana.post_influx.model.CampaignLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CampaignLogRepository extends JpaRepository<CampaignLog, Long> {
    List<CampaignLog> findByUserId(Long userId);
}