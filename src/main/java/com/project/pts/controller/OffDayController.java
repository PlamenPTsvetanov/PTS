package com.project.pts.controller;

import com.project.pts.entities.OffDayEnum;
import com.project.pts.services.OffDayService;
import com.project.pts.views.in.OffDayInView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("OffDayController")
@RequestMapping(value = "off")
public class OffDayController {
    @Autowired
    private OffDayService service;

    @RequestMapping(path = "/set", method = RequestMethod.POST)
    public ResponseEntity<String> set(@RequestParam("actualDate") String actualDate,
                                        @RequestParam("type") String type,
                                        @RequestParam("reasoning") String reasoning) {
        String message = "";
        if (UserController.getLoggedId() == null) {
            return new ResponseEntity<>("Must log in to create off day!", HttpStatus.BAD_REQUEST);
        }
        message = service.createOffDay(new OffDayInView(actualDate, UserController.getLoggedId(), type, reasoning)) ? "Off day created successfully!" : "Cannot create off day!";
        return ResponseEntity.ok().body(message);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllOffDays() {
        return ResponseEntity.ok().body(service.getAllOffDays());
    }
}
