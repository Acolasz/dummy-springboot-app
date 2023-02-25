package hu.kukutyin.dummy.service.app.dao.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConstantsDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String groupId;
    private String groupIdKey;
    private String groupIdValue;
    private String description;
}
