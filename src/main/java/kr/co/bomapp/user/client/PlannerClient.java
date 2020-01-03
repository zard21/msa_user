package kr.co.bomapp.user.client;

import kr.co.bomapp.user.model.Planner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "planner-client", url = "http://localhost:9090")
public interface PlannerClient {

    @GetMapping(value = "/planners/{id}")
    Planner getPlannerInfo(@PathVariable String id);
}
