package com.project.pts.services;

import com.project.pts.views.out.ActivityOutView;
import org.springframework.stereotype.Service;

@Service
public interface IActivityService {
    ActivityOutView getNewestActivityByUser(Long userId);
}
