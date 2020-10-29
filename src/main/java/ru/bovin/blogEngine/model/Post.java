package ru.bovin.blogEngine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.bovin.blogEngine.model.enumerated.ModerationStatus;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "is_active")
  private Boolean isActive;

  @NotNull
  @Column(name = "moderation_status")
  @Enumerated(EnumType.STRING)
  private ModerationStatus moderationStatus;

  @Column(name = "moderator_id")
  private Integer moderationId;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @NotNull
  private LocalDateTime time;

  @NotNull
  private String title;

  @NotNull
  private String text;

  @NotNull
  @Column(name = "view_count")
  private Integer viewCount;

  @OneToMany(mappedBy = "post")
  @JsonIgnore
  @ToString.Exclude
  private List<PostVotes> postVotes;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "posts")
  private List<Tags> tags;

}
