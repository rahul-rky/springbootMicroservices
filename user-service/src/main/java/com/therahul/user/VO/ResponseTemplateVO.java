package com.therahul.user.VO;

import com.therahul.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ResponseTemplateVO {
    private User user;
    private Department department;
}
