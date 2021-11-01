package com.snehil.questquiz.entity;


import lombok.*;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {
    @Id
    private int id;
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "role")
    @Builder.Default
    private Set<UserRole> userRole=new HashSet<>();
}
