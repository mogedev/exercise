package com.citibanamex.exercire.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface HeaderService {

    Map< String, List< String >> header(HttpServletRequest request);
    Map< String, List< String >> headerFilter(HttpServletRequest request, List< String > headersName);

}
