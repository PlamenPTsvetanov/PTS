package com.project.pts.services.impl;

import com.project.pts.entities.OffDayEntity;
import com.project.pts.entities.OffDayEnum;
import com.project.pts.entities.UserEntity;
import com.project.pts.repositories.IOffDayRepository;
import com.project.pts.repositories.IUserRepository;
import com.project.pts.services.IUserService;
import com.project.pts.services.OffDayService;
import com.project.pts.views.in.OffDayInView;
import com.project.pts.views.out.OffDayOutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OffDayServiceImpl implements OffDayService {
    @Autowired
    private IOffDayRepository repository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean createOffDay(OffDayInView in) {
        try {
            UserEntity user = userRepository.getReferenceById(in.getUserId());
            OffDayEntity offDayEntity = new OffDayEntity(in.getActualDate(), user, in.getType(), in.getReasoning());
            repository.save(offDayEntity);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<OffDayOutView> getAllOffDays() {
        List<OffDayEntity> all = repository.findAll();
        List<OffDayOutView> view = new ArrayList<>();

        for (OffDayEntity offDayEntity : all) {
            view.add(map(offDayEntity));
        }

        return view;
    }

    private OffDayOutView map(OffDayEntity entity){
        String color = "";
        switch (entity.getType()){
            case SICK:
                color = "#00BEFF";
                break;
            case LEAVE:
                color = "#C3C3C3";
                break;
            case HOLIDAY:
                color = "#FF6700";
                break;
        }
        return new OffDayOutView(entity.getActualDate(), entity.getUser().getUsername(), entity.getType(), entity.getReasoning(), color);
    }
}
