package com.citibanamex.exercire.service;

import com.citibanamex.exercire.service.HeaderService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class HeaderServiceImpl implements HeaderService {


    @Override
    public Map<String, List<String>> header(HttpServletRequest request) {

        Map< String, List<String> > response = new HashMap<>();

        if ( request.getHeaderNames() != null) {

            List<String> headerNames = Collections.list( request.getHeaderNames() );

            response = headerNames
                    .stream()
                    .collect(Collectors.toMap(
                            Function.identity(),
                            headerName -> Collections.list( request.getHeaders(headerName) )
                    ));

            return response;


        }

        return response;
    }

    @Override
    public Map<String, List<String>> headerFilter(HttpServletRequest request, List<String> headerNames) {

        Map<String, List<String> > response = new HashMap<>();

        if ( headerNames != null ) {

            response  = headerNames
                    .stream()
                    .collect( Collectors.toMap(
                            Function.identity(),
                            headerName -> Collections.list(
                                    request.getHeaders( headerName )
                            )
                    ));

            return response;

        }

        return response;
    }
}
