package kr.co.bomapp.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kr.co.bomapp.user.client.PlannerClient;
import kr.co.bomapp.user.model.Planner;
import kr.co.bomapp.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private PlannerClient plannerClient;

    @HystrixCommand(fallbackMethod = "getUserInfoFallback")
    public User getUserInfo(String userId) {
        // get User Information from Persistence
        User user = User.builder()
                    .id(userId)
                    .name("Eungjoo Kim")
                    .email("eungjoo.kim@bomapp.co.kr")
                    .phoneNo("010-2345-6789")
                    .plannerId("1")
                    .build();

        // get Planner Information from Planner Service (by REST API)
        Planner planner = plannerClient.getPlannerInfo(user.getPlannerId());
        user.setPlannerName(planner.getName());

        return user;
    }

    @SuppressWarnings("unused")
    public User getUserInfoFallback(String userId) {
        User user = User.builder()
                .id(userId)
                .name("Eungjoo Kim")
                .email("eungjoo.kim@bomapp.co.kr")
                .phoneNo("010-2345-6789")
                .plannerId("1")
                .build();

        user.setPlannerName("");

        return user;
    }
}
