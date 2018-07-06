package cn.oyo.api.proxy.controller;

import cn.oyo.api.proxy.model.qo.BookingCreateQO;
import cn.oyo.api.proxy.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yezhou on 2018/07/06.
 */
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/createBooking", method = RequestMethod.POST)
    public void createBooking(@RequestBody BookingCreateQO bookingQO) {

    }

}
