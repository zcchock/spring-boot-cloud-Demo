
package com.zcchock.controller;

import com.google.common.collect.Maps;
import com.zcchock.ZuulGateWayAggregationApplication;
import com.zcchock.entity.User;
import com.zcchock.service.AggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

@RestController
public class AggregationController {

    public static final Logger logger = LoggerFactory.getLogger(ZuulGateWayAggregationApplication.class);

    @Autowired
    private AggregationService aggregationService;

    @GetMapping("/aggregate/{id}")
    public DeferredResult<HashMap<String, User>> aggregate(@PathVariable String id) {

        Observable<HashMap<String, User>> result = this.aggregateObservable(id);
        return this.toDeferredResult(result);
    }

    private Observable<HashMap<String, User>> aggregateObservable(String id) {

        return Observable.zip(
                this.aggregationService.getUserById(id),
                this.aggregationService.getMovieUserByUserId(id),
                (user, movieUser) -> {
                    HashMap<String, User> map = Maps.newHashMap();
                    map.put("user", user);
                    map.put("movieUser", movieUser);
                    return map;
                });
    }

    private DeferredResult<HashMap<String, User>> toDeferredResult(Observable<HashMap<String, User>> details) {
        DeferredResult<HashMap<String, User>> result = new DeferredResult<>();

        details.subscribe(new Observer<HashMap<String, User>>() {
            @Override
            public void onCompleted() {
                logger.info("完成…………");
            }

            @Override
            public void onError(Throwable throwable) {
                logger.info("发生错误", throwable);
            }

            @Override
            public void onNext(HashMap<String, User> stringUserHashMap) {
                result.setResult(stringUserHashMap);
            }
        });
        return result;
    }

}


