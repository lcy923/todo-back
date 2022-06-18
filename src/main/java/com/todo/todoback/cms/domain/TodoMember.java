package com.todo.todoback.cms.domain;
import com.todo.todoback.domain.Role;
import com.todo.todoback.domain.TodoContents;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class TodoMember implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "userid", length = 30, nullable = false, unique = true)
    private String userid;

    @Column(name = "userpw", length = 100, nullable = false)
    private String userpw;

    @Column(name = "username", length = 10, nullable = false)
    private String username;

    @Column(name = "userbirth", length = 20, nullable = false)
    private String userbirth;

    @Column(name = "useremail", length = 100, nullable = false)
    private String useremail;

    @Column(name = "createdate", length = 100, nullable = false)
    private String createdate;

    @Column(name = "deldate", length = 100, nullable = true)
    private String deldate;

    @Column(name = "role", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "todoMember")
    private List<TodoContents> todoContents = new LinkedList<>();

    @Builder
    public TodoMember(String userid, String userpw, String username, String userbirth, String useremail, String createdate, String deldate, Role role) {
        this.userid = userid;
        this.userpw = userpw;
        this.username = username;
        this.userbirth = userbirth;
        this.useremail = useremail;
        this.createdate = createdate;
        this.deldate = deldate;
        this.role = role;
    }
}