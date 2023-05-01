package com.project.pts.services.impl;

import com.project.pts.entities.TaskEntity;
import com.project.pts.repositories.ITaskRepository;
import com.project.pts.services.ITaskService;
import com.project.pts.views.out.TaskOutView;
import com.project.pts.views.out.UserOutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskRepository activityRepository;

    @Override
    public List<TaskOutView> getNewestActivityByUser(Long userId) {
        return map(activityRepository.getLatestActivities(userId));
    }

    private List<TaskOutView> map(List<TaskEntity> entities) {
        List<TaskOutView> ret = new ArrayList<>();
        for (TaskEntity entity : entities) {
            UserOutView view = new UserOutView(entity.getUser().getId(),
                    entity.getUser().getInsertedAt(),
                    entity.getUser().getFirstName(),
                    entity.getUser().getLastName(),
                    entity.getUser().getUsername(),
                    entity.getUser().getEmailAddress());
            ret.add(new TaskOutView(entity.getName(), entity.getDescription(), entity.getStartDate(), entity.getEndDate(), view));
        }

        return ret;
    }
}
