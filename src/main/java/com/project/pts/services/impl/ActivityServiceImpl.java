package com.project.pts.services.impl;

import com.project.pts.entities.ActivityEntity;
import com.project.pts.repositories.IActivityRepository;
import com.project.pts.services.IActivityService;
import com.project.pts.views.out.ActivityOutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;

@Component
public class ActivityServiceImpl implements IActivityService {

    @Autowired
    private IActivityRepository activityRepository;

    @Override
    public ActivityOutView getNewestActivityByUser(Long userId) {
        return map(activityRepository.getLatestActivity(userId));
    }

    private ActivityOutView map(ActivityEntity entity){
        return entity == null ? null : new ActivityOutView(entity.getTaskId(), entity.getMessage(), entity.getCreatedOn());
    }
}
