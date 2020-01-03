package kr.co.bomapp.user.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    String id;
    String name;
    String email;
    String phoneNo;

    String plannerId;
    String plannerName;
}
