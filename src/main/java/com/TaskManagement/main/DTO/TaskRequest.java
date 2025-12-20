package com.TaskManagement.main.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {

        private String title;
        private String description;
        private String status;
        private Long user_id;


}
