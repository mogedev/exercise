package com.citibanamex.exercire.controller;

import com.citibanamex.exercire.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/header")
public class HeaderController {

    @Autowired
    HeaderService headerService;

    @GetMapping()
    public Map< String, List<String>> hearder(HttpServletRequest request) {
        return headerService.header(request);
    }

    @GetMapping( "/filter")
    public Map< String, List<String>> hearderFilter(HttpServletRequest request,
                                                    @RequestParam List<String> headerNames ) {
        return headerService.headerFilter(request, headerNames);
    }

}
