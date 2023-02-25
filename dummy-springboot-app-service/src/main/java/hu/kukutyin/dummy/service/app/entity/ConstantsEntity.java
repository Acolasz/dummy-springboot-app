package hu.kukutyin.dummy.service.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import hu.kukutyin.dummy.service.app.valueset.EntitiesConstants;

@Entity
@Table(name = EntitiesConstants.CONSTANTS_TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ConstantsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Generated unique ID with sequence
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(updatable = false, nullable = false)
    private Long id;

    /**
     * A group of keys
     */
    private String groupId;
    /**
     * Key
     */
    private String constKey;

    /**
     * Value of key
     */
    private String constValue;

    /**
     * Description od key rows
     */
    private String description;
}
