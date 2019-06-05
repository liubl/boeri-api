package com.lboeri.boeriapi.record;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String Id;
    String username;
    String password;
    String name;
}
