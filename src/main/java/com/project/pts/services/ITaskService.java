package com.project.pts.services;

import com.project.pts.views.out.TaskOutView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITaskService {
    List<TaskOutView> getNewestActivityByUser(Long userId);
}
