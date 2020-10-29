package ru.bovin.blogEngine.model;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_votes")
public class PostVotes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  @NotNull
  private LocalDateTime time;

  @NotNull
  private byte value;
}
