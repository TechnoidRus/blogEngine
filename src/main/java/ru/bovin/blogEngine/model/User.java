package ru.bovin.blogEngine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "is_moderator")
  @NotNull
  private Boolean isModerator;

  @Column(name = "reg_time")
  private LocalDateTime regTime;

  @NotNull
  private String name;

  @NotNull
  private String email;

  @NotNull
  private String password;

  private String code;

  private String photo;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonIgnore
  @ToString.Exclude
  private List<Post> posts;

  @OneToMany(mappedBy = "user")
  @JsonIgnore
  @ToString.Exclude
  private List<PostVotes> postVotes;

}
