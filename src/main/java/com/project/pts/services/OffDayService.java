package com.project.pts.services;

import com.project.pts.views.in.OffDayInView;
import com.project.pts.views.out.OffDayOutView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OffDayService {
    boolean createOffDay(OffDayInView in);

    List<OffDayOutView> getAllOffDays();
}
